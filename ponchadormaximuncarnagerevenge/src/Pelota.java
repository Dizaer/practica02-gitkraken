
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pelota {

    private Image imagen;
    //Coordenadas de la pelota
    private int X;
    private int Y;
    private int velocidad_X;
    private int velocidad_Y;
    private int limite_izquierda = 0;
    private int limite_derecha;
    private int limite_superior = 0;

    public Pelota(int x, int y) {
        //coordenadas iniciales
        this.X = x;
        this.Y = y;
        //imagen de la pelota
        imagen = new ImageIcon(getClass().getResource("pelota33.jpg")).getImage();
    }

    public void cambiarImagen(String nombre) {
        imagen = new ImageIcon(getClass().getResource(nombre)).getImage();
    }

    //dado las dimensiones del contenedor JPanel 
    public void ponerLimites(int width, int height) {
        limite_derecha = width - imagen.getHeight(null);    // *falta quitar ancho de imagen
    }

    //recalcula variables para dar la sensacion de movimiento
    public void mover() {
        //nueva posicion
        X += velocidad_X;
        Y += velocidad_Y;
        //controla que la pelota no salga de los limites del contenedor
        if (X < this.limite_izquierda) {
            X = 0;
            velocidad_X = -velocidad_X;
        } else if (X > limite_derecha) {
            X = limite_derecha;
            velocidad_X = -velocidad_X;
        }
        if (Y < this.limite_superior) {
            Y = 0;
            velocidad_Y = -velocidad_Y;

        }
        // *falta para rebotar abajo

    }

    public void ponerVelocidad() {
        velocidad_X = darNumeroAleatorio(4);
        velocidad_Y = darNumeroAleatorio(8);
    }

    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imagen, X, Y, null);
    }

    //devuelve un número aleatorio entre 1 y MAX
    private int darNumeroAleatorio(int Max) {
        return (int) (Math.random() * Max + 1);
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

    public void retornar() {
        X = 0;
        Y = 0;
    }

    public void rebotarbolasmaduras(int amlover290) {
        Y=amlover290-imagen.getHeight(null);
        velocidad_Y = -velocidad_Y;
    }
}

