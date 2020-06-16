package Button;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
public class Button extends JButton {
    private Paint paint;
    private boolean over;
    public Button() {
        initComponents();
        setOpaque(false);
        setForeground(Color.WHITE);
        setBackground(new Color(32, 136, 203));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
 
        addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }
        });
    }
    public boolean isOver() {
        return over;
    }
 
    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        paint = new GradientPaint(0, 0, new Color(2,27,52) , 0, getHeight(), new Color(2,27,52));
        if(isOver()){
            paint = new GradientPaint(0, 0, Color.BLACK, 0, getHeight(), Color.BLACK);
        }else{
            paint = new GradientPaint(0, 0, new Color(2,27,52), 0, getHeight(), new Color(2,27,52));
        }
        gd.setPaint(paint);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        gd.dispose();
        super.paintComponent(g);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    }
