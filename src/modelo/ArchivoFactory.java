package modelo;

public class ArchivoFactory implements IArchivoFactoryMethod {
    @Override
    public IArchivoStrategy crearArchivo(String data) {
        data = data.replace('"',' ');
        String[] partes = data.split("\\.");
        String extension = partes[partes.length-1];
        if(extension.compareTo("json") == 0){
            return new JSON();
        }
        if(extension.compareTo("xml") == 0) {
            return new XML();
        }
        if(extension.compareTo("txt") == 0) {
            return new Texto();
        }
    return null;
    }
}
