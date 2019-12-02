package swing_project_1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tic_Tac_Toe extends JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    JButton [] jbt;
    JLabel winnerLabel = new JLabel("Winner is...");
    JLabel playerLabel = new JLabel("Player's turn");
    JLabel timeLabel = new JLabel();

    Player player = Player.X;
    boolean gaming = true;
    String [][] board = new String[3][3];
    double gameTime = 0;

    public Tic_Tac_Toe() {
        setSize(500, 500);
        setTitle("3 X 3 오목 게임");
        setDefaultCloseOperation(2);
        setLayout(new BorderLayout());

        // 시간 패널
        var np = new JPanel(new FlowLayout(FlowLayout.LEFT));
        np.add(timeLabel);

        // 삼목 패널
        var cp = new JPanel(new GridLayout(3, 3, 5, 5));
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        jbt = new JButton[9];
        for (int i = 0; i < jbt.length; i++) {
            cp.add(jbt[i] = new JButton());
            jbt[i].setBackground(Color.white);
            jbt[i].setBorder(new LineBorder(Color.black));
            int position = i;
            jbt[i].addActionListener(e -> clickBoard(this.player, position));
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

        sp_np.add(playerLabel);
        sp_sp.add(winnerLabel);

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
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                Thread.interrupted();
            }
        });
    }

    private void gameStart() {
        long l = 0;
        while (gaming) {
            try {
                if (gameTime != 0) {
                    l = (long) gameTime;
                }
                if (System.currentTimeMillis() < l) {
                    gameTime = (l - System.currentTimeMillis()) / 1000;
                    System.out.println(gaming + "초 경과");
                    return;
                }

                timeLabel.setText(sdf.format(new Date((long) gameTime)));
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
        jbt[position].setText(String.valueOf(player));
        jbt[position].setEnabled(false);
        board[position / 3][position % 3] = String.valueOf(player);
        winningRule(position, player.getPlayer());
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
            return;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println(3 % 3);
        System.out.println("--------------------------");
        new Tic_Tac_Toe().setVisible(true);
    }
}

