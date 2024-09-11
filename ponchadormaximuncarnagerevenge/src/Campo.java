
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Campo extends JPanel {

    //instancia a la pelota en posicion (X,Y) => (0,0)
    private Pelota mipelota = new Pelota(0, 0);
    private Timer timer;
    private Ponchador miponchador;

    //constructor
    public Campo(Dimension d) {
        this.setSize(d);
        this.setPreferredSize(d);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(new Color(255, 255, 255));
        mipelota.ponerLimites(getWidth(), getHeight());
        miponchador = new Ponchador(getWidth(), getHeight(), 20);
        miponchador.ponerLimites(getWidth(), getHeight());
        //para la animación
        timer = new Timer(16, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // mover la pelota
                mipelota.mover();
                repaint();
                verificarPonchada();
            }
        });
    }

    //Controla el inicio y fin de la animación
    public void animar(boolean activar) {
        mipelota.retornar();
        mipelota.cambiarImagen("pelota33.jpg");
        if (activar) {
            // configurar la velocidad
            mipelota.ponerVelocidad();
            timer.start();
        } else {
            timer.stop();
        }
    }

    //pinta la animación
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // dibujar la pelota
        mipelota.dibujar(g);
        miponchador.dibujar(g);
    }
//mueve el ponchador

    public void izquierda() {
        miponchador.moverI();
        repaint();
    }

    public void derecha() {
        miponchador.moverD();
        repaint();
    }

    private void verificarPonchada() {
// si la pelota esta en el rango Y de la tabla, se verifica por los rangos X
        if (mipelota.YB() >= miponchador.YA()) {
            if (mipelota.XI() >= miponchador.XI() && (mipelota.XI() <= miponchador.XD())) {
//se poncho
                mipelota.rebotarbolasmaduras(miponchador.YA());
            } else if (mipelota.XD() >= miponchador.XI() && (mipelota.XD() <= miponchador.XD())) {
//se poncho
                mipelota.rebotarbolasmaduras(miponchador.YA());
            }
        }
        if (mipelota.YB() >= miponchador.YB()) {
            mipelota.cambiarImagen("pelota34.jpg");
            timer.stop();
        }
    }
}
