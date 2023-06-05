import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class learnMore extends JFrame {
    
    private SineGraph sineGraph;
    
    learnMore() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLayout(null);
        
        sineGraph = new SineGraph();
        sineGraph.setBounds(10, 10, 800, 400);
        this.add(sineGraph);
        
        sineGraph.addMouseWheelListener(new ZoomListener());
    }
    
    class ZoomListener implements MouseWheelListener {
        private static final double ZOOM_FACTOR = 1.1;  // Adjust the zoom factor as needed
        
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            int notches = e.getWheelRotation();
            
            if (notches < 0) {
                sineGraph.zoomIn(ZOOM_FACTOR);
            } else {
                sineGraph.zoomOut(ZOOM_FACTOR);
            }
        }
    }
    
    class SineGraph extends JPanel {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 400;
        private static final int AMPLITUDE = 100;
        private static final int PERIOD = 200;
        private static final int PHASE_SHIFT = 0;
        
        private double scaleFactor = 1.0;
        
        public void zoomIn(double factor) {
            scaleFactor *= factor;
            repaint();
        }
        
        public void zoomOut(double factor) {
            scaleFactor /= factor;
            repaint();
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g;
            
            int startX = 0;
            int endX = getWidth();
            int centerY = getHeight() / 2;
            
            g2d.setColor(Color.BLACK);
            g2d.drawLine(startX, centerY, endX, centerY);  // X-axis
            
            g2d.setColor(Color.RED);
            int scaledAmplitude = (int) (AMPLITUDE * scaleFactor);
            
            int previousX = startX;
            int previousY = centerY - (int) (Math.sin((startX + PHASE_SHIFT) * 2 * Math.PI / PERIOD) * scaledAmplitude);
            
            for (int x = startX + 1; x <= endX; x++) {
                int y = centerY - (int) (Math.sin((x + PHASE_SHIFT) * 2 * Math.PI / PERIOD) * scaledAmplitude);
                g2d.drawLine(previousX, previousY, x, y);
                previousX = x;
                previousY = y;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new learnMore().setVisible(true);
        });
    }
    
}
