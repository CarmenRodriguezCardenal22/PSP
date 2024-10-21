import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Act2_3 extends Applet implements ActionListener {
    private Thread h;
    long cont=0;
    private boolean parar;
    private Font fuente;
    private Button b1,b2;
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            b1.setLabel("Continuar");
            if(h!=null&&h.isAlive()) {
            }
            else{
                h=new Thread(String.valueOf(this));
                h.start();
            }
        } else if (e.getSource()==b2) {
            parar=true;

        }
    }
    public void start() {
    }

    public void init() {
        setBackground(Color.yellow);
        add(b1=new Button("Iniciar contador"));
        b1.addActionListener((ActionListener) this);
        add(b2=new Button("Parar contador"));
        b2.addActionListener((ActionListener) this);
        fuente = new Font("Verdana", Font.BOLD, 26);
    }
    public void paint(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.setFont(fuente);
        g.drawString(Long.toString((long) cont),80,100);
    }

    class HiloContador extends Thread {
        @Override
        public void run() {
            parar=false;
            Thread hiloAtual=Thread.currentThread();
            while (h==hiloAtual&&!parar) {
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
                cont++;
            }
        }
    }
}