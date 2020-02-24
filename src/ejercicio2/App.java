package ejercicio2;

public class App {
    public static void main(String[] args) {
        MD5 comprobador = new MD5();
        try {
            System.out.println(comprobador.sacarMD5DeSumatorio("pruebaImagenMD5.jpg")); //ruta imagen en la carpeta proyecto PSPTema5
            System.out.println(comprobador.sacarMD5DeSumatorio("C:\\Users\\desco\\Desktop\\pruebaImagenMD5.jpg")); //ruta en el escritorio de la misma imagen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
