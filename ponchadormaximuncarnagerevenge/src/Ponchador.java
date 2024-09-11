
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ponchador {

    private Image imagen;
    //Coordenadas de la pelota
    private int X = 160;
    private int Y = 225;
    private int velocidad_X;
    private int limite_izquierda = 0;
    private int limite_derecha;

    public Ponchador(int ancho, int alto, int avance) {
        //coordenadas iniciales
        this.velocidad_X = avance;
        //imagen de la pelota
        imagen = new ImageIcon(getClass().getResource("Tabla.jpg")).getImage();
    }

    public void ponerLimites(int width, int height) {
        limite_derecha = width - imagen.getHeight(null) - imagen.getHeight(null) - 10;  // *falta quitar ancho de imagen
    }

    public void moverD() {
//mover tabla a la derecha, incrementar con el avance
        X += velocidad_X;
//controla que la tabla no salga de los límites del contenedor
        if (X > this.limite_derecha) {
            X = this.limite_derecha;

        }
    }

    public void moverI() {
//mover tabla a la izquierda, incrementar con el avance
        X -= velocidad_X;
//controla que la tabla no salga de los límites del contenedor
        if (X < this.limite_izquierda) {
            X = this.limite_izquierda;

        }
//controla que la tabla no salga de los límites del contenedor
    }

    public void dibujar(Graphics g) {
// idéntico a la pelota
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imagen, X, Y, null);
    }

    public int XI() {
        return X;
    }

    public int XD() {
        return X + imagen.getWidth(null);
    }

    public int YA() {
        return Y;
    }

    public int YB() {
        return Y + imagen.getHeight(null);
    }
}
