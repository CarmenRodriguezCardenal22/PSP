import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Act2_5 extends Applet implements ActionListener {
    private HiloContador h1,h2;
    private Font fuente;
    private Button b1,b2;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            h1.interrumpir();
            b1.setLabel("Finalizado Hilo 1");
        } else if (e.getSource()==b2) {
            h2.interrumpir();
            b2.setLabel("Finalizado Hilo 2");
        }
    }
    public void start() {

    }

    public void init() {
        h1=new HiloContador(100,1000);
        h1.start();
        h2=new HiloContador(100,1000);
        h2.start();
        setBackground(Color.yellow);
        add(b1=new Button("Finalizar Hilo 1"));
        b1.addActionListener((ActionListener) this::actionPerformed);
        add(b2=new Button("Finalizar Hilo 2"));
        b2.addActionListener((ActionListener) this::actionPerformed);
        fuente = new Font("Verdana", Font.BOLD, 26);
    }
    public void paint(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.setFont(fuente);
        long c1=h1.getCont();
        long c2=h2.getCont2();
        g.drawString(Long.toString((long) c1),80,100);
        g.drawString(Long.toString((long) c2),80,150);
    }

    class HiloContador extends Thread {
        public long cont,cont2;
        boolean enEjecucion = true;
        public HiloContador(long cont,long cont2) {
            this.cont=cont;
            this.cont2=cont2;
        }

        public long getCont() {
            return cont;
        }
        public long getCont2() {
            return cont2;
        }
        public void interrumpir() {
            enEjecucion = false;
        }
        public void run() {
            Thread hiloAtual=Thread.currentThread();
            while (h1==hiloAtual&&enEjecucion) {
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
                cont++;
            }
            while (h2==hiloAtual&&enEjecucion) {
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
                cont2++;
            }
        }
    }
}
