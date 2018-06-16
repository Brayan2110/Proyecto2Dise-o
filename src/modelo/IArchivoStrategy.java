package modelo;


public interface IArchivoStrategy {
    DataDTO leerArchivo(String archivo);
    String guardarArchivo(String archivo, DataDTO data);
}
