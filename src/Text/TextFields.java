package Text;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
public class TextFields extends JTextField {
    public TextFields(){
        super();
        setOpaque(false);
        setBorder(new EmptyBorder(10,10,10,10));
        setHorizontalAlignment(LEFT);
        initListener();
    }
    private String Place ="";
    public TextFields(String Text){
        super(Text);
        initListener();
    }
    public TextFields(int Col){
        super(Col);
        initListener();
    }
    public TextFields(Document Doc, String Text, int Col){
        super(Doc, Text, Col); initListener();
    }

    private void initListener() {
        addKeyListener(new KeyAdapter(){
           public void keyPressed(KeyEvent e){
               super.keyPressed(e); 
               repaint();
           }
        });
    }
    public String getPlace(){
        setHorizontalAlignment(LEFT);
        return Place;
    }
    public void setPlace(String Place){
        this.Place = Place;
        repaint();
    }
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        if(getText().trim().equals("")){
            Font font = getFont().deriveFont(Font.BOLD).deriveFont(Font.ITALIC);
            Graphics2D g2d = (Graphics2D)g;
            FontMetrics FM = g2d.getFontMetrics(font);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font);
            
            java.awt.geom.Rectangle2D rec = FM.getStringBounds(Place, g2d);
            int th = (int)rec.getHeight();
            g2d.drawString(Place, 7, th+5);
        } 
        Color Dark = new Color(1F,1F,1F,0F);
        Color Light = new Color(1F,1F,1F,0.3F);
        GradientPaint paint = new GradientPaint(0,0, Dark, 0, getHeight()/2,Light);
        g2.setPaint(paint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, getHeight(), getHeight());
        g2.dispose();
    }

    public String setText(double ipk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
