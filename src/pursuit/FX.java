package pursuit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class FX extends JFrame implements MouseListener {
    public static FX fx = new FX();
    public static JPanel panel;


    private static void initializeJFrame(){
        fx.setSize(400, 400);
        fx.setVisible(true);

        fx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fx.addMouseListener(fx);

    }

    /**
     * Initialize the JPanel with the custom MyPanel class
     */
    private static void initializeJPanel(){
        panel = new MyPanel();

        fx.add(panel);
        fx.pack();
    }

    /**
     * Initializes the JFrame and it's components
     * Initializes the JPanel
     * @throws IOException for the image reading (file not found)
     */
    public static void init() throws IOException {
        initializeJFrame();
        initializeJPanel();

        fx.setSize(1200, 700);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("new MathUtils.point(" + e.getX() + "," + (e.getY() - 30) + "),");
        Main.pts[Main.ptsN] = new MathUtils.point(e.getX(), e.getY() - 30);
        Main.ptsN++;
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }


    public static class MyPanel extends JPanel implements ActionListener {

        Timer timer=new Timer(10, this);

        public void paint(Graphics g) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 3000, 3000);
            ArrayList<Point> toDraw = new ArrayList<>();
            toDraw.addAll(Main.toDraw);
            g.setColor(Color.white);
//            for(int i = 0;i<Main.x.length;i++){
//                g.fillOval(Main.x[i], Main.y[i], 10, 10);
//            }
//            g.drawOval((int)Robot.getX() - 100, (int)Robot.getY() - 100, 200, 200);
            g.drawOval((int)Main.goalX-3, (int)Main.goalY-3, 6, 6);
            for(int i = 0;i<Main.ptsN- 1;i++){
                g.drawLine((int)Main.pts[i].getX(), (int)Main.pts[i].getY(), (int)Main.pts[i+1].getX(), (int)Main.pts[i+1].getY());
            }
            if(toDraw.size() >= 1) {
                Point l = toDraw.get(0);
                int ct =0;
                for (Point p : toDraw) {
                    ct++;
                    Color h = new Color(255, Math.min(ct, 255), 0);
                    g.setColor(h);
                    g.drawLine(p.x, p.y, l.x, l.y);
                    g.fillOval(p.x-5, p.y-5, 10, 10);
                    l = p;
                }

            }

            g.setColor(Color.white);
            for(int j =1;j<=13;j++){
                for(int i = 1;i<=7;i++){
                    g.fillOval(j * 80, i * 80, 5, 5);
                }
            }
            g.setColor(Color.black);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==timer){
                repaint();// this will call at every 1 second
            }
        }

    }
}
