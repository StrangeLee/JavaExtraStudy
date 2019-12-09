package swing_project_1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 친구들끼리 짜투리 시간때 간간이 하던
 * 3*3 삼목게임을 java swing 으로 구현해 보았습니다.
 */

public class Tic_Tac_Toe extends JFrame {
    public static final Font BASIC_FONT = new Font("맑은 고딕", 0 , 20);
    public static final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

    JButton [] jbt;
    JLabel winnerLabel = new JLabel("Winner is...");
    JLabel playerLabel = new JLabel("Player's turn");
    JLabel timeLabel = new JLabel();

    Player player = Player.X;
    String [][] board = new String[3][3];
    boolean gaming = true;
    double gameTime = 0;

    public Tic_Tac_Toe() {
        setSize(500, 500);
        setTitle("3 X 3 오목 게임");
        setDefaultCloseOperation(2);
        setLayout(new BorderLayout());

        // 시간 패널
        var np = new JPanel(new FlowLayout(FlowLayout.LEFT));
        np.add(timeLabel);
        timeLabel.setText("00:00");

        // 삼목 패널
        var cp = new JPanel(new GridLayout(3, 3, 5, 5));
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        jbt = new JButton[9];
        for (int i = 0; i < jbt.length; i++) {
            int position = i;
            cp.add(jbt[i] = buttonAction("", 20, e -> clickBoard(this.player, position)));
        }

        // board 초기화
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }

        // 하단 라벨 패널
        var sp = new JPanel(new BorderLayout());
        var sp_np = new JPanel(new FlowLayout());
        var sp_sp = new JPanel(new FlowLayout());

        playerLabel.setFont(BASIC_FONT); // 플레이어 턴 표시
        winnerLabel.setFont(BASIC_FONT); // 승리자 표시
        sp_np.add(playerLabel);
        //sp_sp.add(winnerLabel);

        sp.add(sp_np, "North");
        sp.add(sp_sp, "South");

        add(np, "North");
        add(cp);
        add(sp, "South");

        new Thread(() -> gameStart()).start();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Thread.interrupted();
            }
        });
    }

    private void gameStart() {
        long l = 0;
        Date date = new Date();
        while (gaming) {
            try {
                Thread.sleep(1000);
                l += 1000;
                date.setTime(l);
                timeLabel.setText(sdf.format(date));
                revalidate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clickBoard(Player player, int position) {
        if (player == Player.X) {
            this.player = Player.Y;
        } else {
            this.player = Player.X;
        }

        // 누른 버튼의 텍스트와 상태 바꾸기
        System.out.println("position : " + position);
        jbt[position].setForeground(player == Player.X ? Color.blue : Color.red);
        jbt[position].setText(String.valueOf(player));
        jbt[position].setEnabled(false);

        // board 의 상태와 그 다음 플레이어 표시
        playerLabel.setText(this.player.toString() + "'s Turn");
        board[position / 3][position % 3] = String.valueOf(player);

        // 승자가 나오는지 확인
        winningRule(position, player.getPlayer());

        revalidate();
        repaint();
    }

    private void winningRule(int position, String player) {
        if ((board[position / 3][0].equals(player) // 3 in row
        && board[position / 3][1].equals(player)
        && board[position / 3][2].equals(player))
        || (board[0][position % 3].equals(player)   // 3 in col
        && board[1][position % 3].equals(player)
        && board[2][position % 3].equals(player))
        || (board[0][0].equals(player) // 3 in diagonal
        && board[1][1].equals(player)
        && board[2][2].equals(player))
        || (board[0][2].equals(player) // 3 in opposite diagonal
        && board[1][1].equals(player)
        && board[2][0].equals(player))) {
                JOptionPane.showMessageDialog(null, player + " 승리");
                winnerLabel.setText("Winner is " + player);
            for (int i = 0; i < jbt.length; i++) {
                jbt[i].setEnabled(false);
            }
            revalidate();
            return;
        }
    }

    private JButton buttonAction(String name, int fontSize, ActionListener action) {
        var jb = new JButton(name);
        jb.setFont(new Font("맑은 고딕", 1, fontSize));
        jb.setText("start");
        jb.addActionListener(action);
        jb.setBackground(Color.white);
        jb.setBorder(new LineBorder(Color.black));

        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jb.setBackground(Color.black);
                jb.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jb.setBackground(Color.white);
                jb.setForeground(Color.black);
            }
        });

        return jb;
    }

    public static void main(String[] args) {
        new Tic_Tac_Toe().setVisible(true);
    }
}

