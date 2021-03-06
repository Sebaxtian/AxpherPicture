/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axpherpicture;

import imagen.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import org.dcm4che2.data.DicomObject;

/**
 * Clase Main del proyecto AxpherPicture
 * 
 * @author Juan Sebastian Rios Sabogal
 * @Fecha sab mar 31 21:01:59 COT 2012
 * @version 0.1
 */


public class AxpherPicture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
         * Imagen en formato Dicom
         */
        /*
        DcmImg objDcmImg = new DcmImg("ImgFuente/ankle.dcm");
        //objDcmImg.guardaY("ImgProcesado/ankle.dcm");
        DicomObject dcmObj;
        dcmObj = objDcmImg.getDicomObject();
        objDcmImg.printHeaders(dcmObj);
        String estudio = objDcmImg.getEstudio();
        if(!estudio.equals("CT") || !estudio.equals("RM")) {
            Imagen imgObj;
            imgObj = objDcmImg.getImagen();
            imgObj.guardarImagen("ImgProcesado/ankle.pgm");
            //-->construye una imagen binaria
            Imagen imgBinariaPGM = new Imagen();
            imgBinariaPGM.setFormato("P2");
            imgBinariaPGM.setNivelIntensidad(1);
            imgBinariaPGM.setN(imgObj.getN());
            imgBinariaPGM.setM(imgObj.getM());
            short matrizGris[][] = new short[imgBinariaPGM.getN()][imgBinariaPGM.getM()];
            for(int i = 0; i < imgBinariaPGM.getN(); i++) {
                for(int j = 0; j < imgBinariaPGM.getM(); j++) {
                    if(imgObj.getMatrizGris()[i][j] < 104) {
                        matrizGris[i][j] = 0;
                    } else {
                        matrizGris[i][j] = 1;
                    }
                }
            }
            imgBinariaPGM.setMatrizGris(matrizGris);
            objDcmImg.setImagen(imgBinariaPGM);
            imgObj = objDcmImg.getImagen();
            imgObj.guardarImagen("ImgProcesado/binariaAnkle.pgm");
            objDcmImg.guardarDcmImg("ImgProcesado/binarioAnkle.dcm");
            objDcmImg.guardaX("ImgProcesado/bi2Ankle.dcm");
            //------
            objDcmImg.guardaY("ImgProcesado/binaria3ankle.dcm");
        }
        */
        
        /**
         * Operaciones
         */
        /*
        String rutaImgPGM = "ImgFuente/noisy.pgm";
        Imagen imgPGM = new Imagen(rutaImgPGM);

        // --->> Filtros
        FiltroNoise fl = new FiltroNoise(imgPGM);
        fl.filtroSigma((short)100);
        fl.getImagen().guardarImagen("ImgProcesado/sigmaNoisy.pgm");

        fl.filtroMediana(3);
        fl.getImagen().guardarImagen("ImgProcesado/medianaNoisy.pgm");

        fl.nagaoMatsuyama();
        fl.getImagen().guardarImagen("ImgProcesado/nagaoMatsuyamaNoisy.pgm");


        String rutaImgPGM2 = "ImgFuente/madera.pgm";
        Imagen imgPGM2 = new Imagen(rutaImgPGM2);
        String rutaImgPGM1 = "ImgFuente/velas.pgm";
        Imagen imgPGM1 = new Imagen(rutaImgPGM1);

        // --->> Cuantizar
        Cuantizar rs = new Cuantizar(imgPGM1);
        rs.asignarBitsPixel(4);
        rs.getObjImagen().guardarImagen("ImgProcesado/Resolucion7Lena.pgm");

        // -->> Operaciones
        rutaImgPGM2 = "ImgFuente/madera.pgm";
        imgPGM2 = new Imagen(rutaImgPGM2);
        rutaImgPGM1 = "ImgFuente/velas.pgm";
        imgPGM1 = new Imagen(rutaImgPGM1);
        
        Operaciones op = new Operaciones();
        op.OrAndXor(imgPGM1, imgPGM2, "and").guardarImagen("ImgProcesado/maderaAndVelas.pgm");
        op.OrAndXor(imgPGM1, imgPGM2, "xor").guardarImagen("ImgProcesado/maderaXorVelas.pgm");
        op.OrAndXor(imgPGM1, imgPGM2, "or").guardarImagen("ImgProcesado/maderaOrVelas.pgm");
        op.suma(imgPGM1, imgPGM2).guardarImagen("ImgProcesado/maderaSumaVelas.pgm");
        op.suma(imgPGM1, 128).guardarImagen("ImgProcesado/velasSuma128.pgm");
        
        rutaImgPGM2 = "ImgFuente/pills.pgm";
        imgPGM2 = new Imagen(rutaImgPGM2);
        rutaImgPGM1 = "ImgFuente/birs.pgm";
        imgPGM1 = new Imagen(rutaImgPGM1);
        
        op.OrAndXor(imgPGM1, imgPGM2, "and").guardarImagen("ImgProcesado/pillsAndBirs.pgm");
        op.OrAndXor(imgPGM1, imgPGM2, "xor").guardarImagen("ImgProcesado/pillsXorBirs.pgm");
        op.OrAndXor(imgPGM1, imgPGM2, "or").guardarImagen("ImgProcesado/pillsOrBirs.pgm");
        op.suma(imgPGM1, imgPGM2).guardarImagen("ImgProcesado/pillsSumaBirs.pgm");
        op.suma(imgPGM1, 128).guardarImagen("ImgProcesado/birsSuma128.pgm");
        */
        
        
        /*
         * Bordes
         */
        /*
        Imagen objImg1 = new Imagen("ImgFuente/rects.pgm");
        FiltroNoise filtroBordes = new FiltroNoise(objImg1);
        
        //filtroBordes.filtroMediana(5);
        filtroBordes.filtroGausiano(5);
        Imagen imgMediana = filtroBordes.getImagen();
        
        filtroBordes = new FiltroNoise(imgMediana);
        
        filtroBordes.filtroSobel();
        filtroBordes.getImagen().guardarImagen("ImgProcesado/sobelRects7.pgm");
        */
        
        /*
        FiltroNoise f2 = new FiltroNoise(imgPGM2);
        f2.filtroSobel();
        f2.getImagen().guardarImagen("ImgProcesado/sobelMadera.pgm");
        
        rutaImgPGM2 = "ImgFuente/rects.pgm";
        imgPGM2 = new Imagen(rutaImgPGM2);
        f2 = new FiltroNoise(imgPGM2);
        f2.filtroMediana(5);
        Imagen imgFil = f2.getImagen();
        f2 = new FiltroNoise(imgFil);
        f2.filtroSobel();
        f2.getImagen().guardarImagen("ImgProcesado/sobelRects.pgm");
        
        rutaImgPGM2 = "ImgFuente/rectshose.pgm";
        imgPGM2 = new Imagen(rutaImgPGM2);
        f2 = new FiltroNoise(imgPGM2);
        f2.filtroSobel();
        imgFil = f2.getImagen();
        f2 = new FiltroNoise(imgFil);
        f2.filtroMediana(3);
        f2.getImagen().guardarImagen("ImgProcesado/sobelRectshose.pgm");
        */
        
        /**
         * Segmentacion
         */
        /*
        DcmImg objDcmImg = new DcmImg("ImgFuente/brain.dcm");
        Imagen objImg = objDcmImg.getImagenMR(333, 738);
        objImg.guardarImagen("ImgProcesado/brain.pgm");
        
        objDcmImg.printHeaders(objDcmImg.getDicomObject());
        
        SegmentacionBrain objSegBrain = new SegmentacionBrain(objDcmImg);
        
        objSegBrain.segmentarMateriaBlanca();
        objDcmImg = objSegBrain.getDcmImg();
        objImg = objDcmImg.getImagenMR(333, 738);
        objImg.guardarImagen("ImgProcesado/brainMB.pgm");
        * 
        */
        
        /*
        //resta
        Imagen imgFuente = new Imagen("ImgFuente/lena.pgm");
        Imagen imgResultado = new Imagen();
        Operaciones operacion = new Operaciones();
        imgResultado = operacion.resta(imgFuente, 64);
        
        imgResultado.guardarImagen("ImgProcesado/restaLena.pgm");
        
        //resta
        imgFuente = new Imagen("ImgFuente/moto.pgm");
        Imagen imgOperando = new Imagen("ImgFuente/coctel.pgm");
        imgResultado = operacion.resta(imgFuente, imgOperando);
        
        imgResultado.guardarImagen("ImgProcesado/motomenoscoctel.pgm");
        
        
        //producto
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.resta(imgFuente, 64);
        
        imgResultado.guardarImagen("ImgProcesado/productoLena.pgm");
        
        //producto
        imgFuente = new Imagen("ImgFuente/birs.pgm");
        imgOperando = new Imagen("ImgFuente/pills.pgm");
        imgResultado = operacion.producto(imgFuente, imgOperando);
        
        imgResultado.guardarImagen("ImgProcesado/birsproductopills.pgm");
        
        //traslacion
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.traslacion(imgFuente, -64, 128);
        
        imgResultado.guardarImagen("ImgProcesado/traslacionLena.pgm");
        
        //refelxion
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.reflexionX(imgFuente);
        
        imgResultado.guardarImagen("ImgProcesado/reflexionXLena.pgm");
        
        imgResultado = operacion.reflexionY(imgFuente);
        
        imgResultado.guardarImagen("ImgProcesado/reflexionYLena.pgm");
        
        
        //media
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.media(imgFuente, 67);
        
        imgResultado.guardarImagen("ImgProcesado/mediaLena.pgm");
        
        imgFuente = new Imagen("ImgFuente/moto.pgm");
        imgOperando = new Imagen("ImgFuente/coctel.pgm");
        imgResultado = operacion.media(imgFuente, imgOperando);
        
        imgResultado.guardarImagen("ImgProcesado/motomediacoctel.pgm");
        
        
        //maximo
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.maximo(imgFuente, 128);
        
        imgResultado.guardarImagen("ImgProcesado/maximoLena.pgm");
        
        imgFuente = new Imagen("ImgFuente/moto.pgm");
        imgOperando = new Imagen("ImgFuente/coctel.pgm");
        imgResultado = operacion.maximo(imgFuente, imgOperando);
        
        imgResultado.guardarImagen("ImgProcesado/motomaximococtel.pgm");
        
        
        //minimo
        imgFuente = new Imagen("ImgFuente/lena.pgm");
        imgResultado = operacion.minimo(imgFuente, 128);
        
        imgResultado.guardarImagen("ImgProcesado/minimoLena.pgm");
        
        imgFuente = new Imagen("ImgFuente/moto.pgm");
        imgOperando = new Imagen("ImgFuente/coctel.pgm");
        imgResultado = operacion.minimo(imgFuente, imgOperando);
        
        imgResultado.guardarImagen("ImgProcesado/motominimococtel.pgm");
        
        
        //cany
        imgFuente = new Imagen("ImgFuente/rects.pgm");
        Canny objCany = new Canny();
        objCany.calculoCanny(imgFuente, 7);
        imgResultado = objCany.getImagen();
        
        imgResultado.guardarImagen("ImgProcesado/canyrects.pgm");
        
        
        //salpimienta
        imgFuente = new Imagen("ImgFuente/canyrects.pgm");
        FiltroNoise filtro = new FiltroNoise(imgFuente);
        filtro.filtroSalPimienta(60);
        imgResultado = filtro.getImagen();
        
        imgResultado.guardarImagen("ImgProcesado/salpimientacanyrects.pgm");
        
        
        //lineas
        imgFuente = new Imagen("ImgFuente/canyrects.pgm");
        filtro = new FiltroNoise(imgFuente);
        filtro.filtroRuidoLineas(60);
        imgResultado = filtro.getImagen();
        
        imgResultado.guardarImagen("ImgProcesado/lineascanyrects.pgm");
        */
        
        /*Imagen imgFuente = new Imagen("ImgFuente/lena.pgm");
        Operaciones operacion = new Operaciones();
        Contraste contraste = new Contraste();
        
        Imagen imgSuma = operacion.suma(imgFuente, 65);
        
        imgSuma.guardarImagen("ImgProcesado/sumaLena.pgm");
        
        
        double valContraste = contraste.getContraste(imgFuente);
        System.out.println("Valor contraste "+valContraste);
        
        Imagen imgSalida = contraste.contrastStretching(imgSuma);
        imgSalida.guardarImagen("ImgProcesado/lenaContrastStretching.pgm");
        
        imgSalida = contraste.correccionGamma(imgFuente, 1.6);
        imgSalida.guardarImagen("ImgProcesado/lenaCorreccionGamma.pgm");*/
        
        
        
        /*DcmImg objDcmImg = new DcmImg("ImgFuente/brain.dcm");
        objDcmImg.printHeaders(objDcmImg.getDicomObject());
        objDcmImg.getPixelSpacing();
        objDcmImg.getEstudio();
        
        Imagen imgDcm = objDcmImg.getImagen();
        imgDcm.guardarImagen("ImgFuente/brainTotal.pgm");*/
        
        /*
        // Normaliza la imagen k-means0 del cerebro
        Imagen imgBrainKmeans0 = new Imagen("ImgFuente/k-means0.pgm");
        imgBrainKmeans0.normalizarImagenGris();
        imgBrainKmeans0.guardarImagen("ImgProcesado/k-means0Normal.pgm");
        
        // Normaliza la imagen k-means1 del cerebro
        Imagen imgBrainKmeans1 = new Imagen("ImgFuente/k-means1.pgm");
        imgBrainKmeans1.normalizarImagenGris();
        imgBrainKmeans1.guardarImagen("ImgProcesado/k-means1Normal.pgm");
        
        // Imagen del cerebro
        Imagen imgBrain1 = new Imagen("ImgFuente/brain1.pgm");
        
        // Operador
        Operaciones operador = new Operaciones();
        
        // Imagen de la resta entre la imagen y el k-means0 del cerebro
        Imagen imgResta = operador.resta(imgBrain1, imgBrainKmeans0);
        imgResta.guardarImagen("ImgProcesado/imgRestaBrain1Kmeans0.pgm");
        
        // Imagen de la resta entre la imagen y el k-means1 del cerebro
        imgResta = operador.resta(imgBrain1, imgBrainKmeans1);
        imgResta.guardarImagen("ImgProcesado/imgRestaBrain1Kmeans1.pgm");
        
        // Extraccion de materia blanca
        Imagen materiaBlanca = segmentarMateriaBlanca(imgBrain1, imgBrainKmeans1);
        materiaBlanca.guardarImagen("ImgProcesado/materiaBlanca.pgm");
        
        // Extraccion de materia Griss
        Imagen materiaGris = segmentarMateriaGris(imgBrain1, materiaBlanca);
        materiaGris.guardarImagen("ImgProcesado/materiaGris.pgm");
        
        
        // Suma de materia blanca y gris
        Imagen imgSuma = operador.suma(materiaBlanca, materiaGris);
        imgSuma.guardarImagen("ImgProcesado/sumaMateriaBlancaGris.pgm");
        */
        
        // Pruebas para Android
        procesaJPG();
        
        /*objDcmImg.guardarImgRaster();
        
        SegmentacionBrain segBrain = new SegmentacionBrain(objDcmImg);
        segBrain.guardaImagen("ImgProcesado/brainSeg.pgm");*/
        /*segBrain.segmentarMateriaBlanca();
        objDcmImg = segBrain.getDcmImg();
        objDcmImg.guardarImgRaster();*/
    }
    
    public static Imagen segmentarMateriaBlanca(Imagen imgCerebro, Imagen imgKmeans) {
        Imagen materiaBlanca = new Imagen();
        // Imagen de la resta entre la imagen y el k-means del cerebro
        Operaciones operador = new Operaciones();
        Imagen imgResta = operador.resta(imgCerebro, imgKmeans);
        
        Histograma histograma = new Histograma(imgResta);
        Umbralizacion umbralizar = new Umbralizacion(histograma, 2); // usa metodo Otsu
        int umbral = umbralizar.getUmbralGris();
        
        // Imagen de materia blanca
        materiaBlanca.setN(imgCerebro.getN());
        materiaBlanca.setM(imgCerebro.getM());
        materiaBlanca.setNivelIntensidad(imgCerebro.getNivelIntensidad());
        materiaBlanca.setFormato(imgCerebro.getFormato());
        short matrizBlanca[][] = new short[imgCerebro.getN()][imgCerebro.getM()];
        
        // Extrae la materia blanca con el umbral
        for(int fila = 0; fila < imgResta.getN(); fila++) {
            for(int columna = 0; columna < imgResta.getM(); columna++) {
                short pixel = imgResta.getMatrizGris()[fila][columna];
                if(pixel > umbral) {
                    //pixel = (short)imgResta.getNivelIntensidad();
                }
                if(pixel < umbral) {
                    pixel = 0;
                }
                matrizBlanca[fila][columna] = pixel;
            }
        }
        
        // Asigna la matriz de materia blanca a la imagen
        materiaBlanca.setMatrizGris(matrizBlanca);
        
        return materiaBlanca;
    }
    
    public static Imagen segmentarMateriaGris(Imagen imgCerebro, Imagen materiaBlanca) {
        Imagen materiaGris = new Imagen();
        // Realiza la resta entre la imagen del cerebro y la materia blanca
        Operaciones operador = new Operaciones();
        Imagen imgResta = operador.resta(imgCerebro, materiaBlanca);
        
        // Imagen de materia gris
        materiaGris.setN(imgCerebro.getN());
        materiaGris.setM(imgCerebro.getM());
        materiaGris.setNivelIntensidad(imgCerebro.getNivelIntensidad());
        materiaGris.setFormato(imgCerebro.getFormato());
        short matrizGris[][] = new short[imgCerebro.getN()][imgCerebro.getM()];
        
        // Extrae la matriz de materia gris
        for(int fila = 0; fila < materiaGris.getN(); fila++) {
            for(int columna = 0; columna < materiaGris.getM(); columna++) {
                short pixel = imgResta.getMatrizGris()[fila][columna];
                matrizGris[fila][columna] = pixel;
            }
        }
        
        // Asigna la matriz de materia gris a la imagen
        materiaGris.setMatrizGris(matrizGris);
        
        return materiaGris;
    }
    
    public static void procesaJPG() {
        try {
            InputStream inS = new FileInputStream("ImgFuente/WonderWoman.jpg");
            try {
                BufferedImage bfImg = ImageIO.read(inS);
                // Espacio de Color
                ColorSpace colorGrises = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                ColorConvertOp ccop = new ColorConvertOp(colorGrises, null);
                BufferedImage bfImgGris = ccop.filter(bfImg, null);
                // Guarda imagen
                ImageIO.write(bfImgGris, "jpg", new File("ImgProcesado/WonderWoman.jpg"));
                // Obtiene objeto imagen de jpg gris
                Imagen imgJPG = getImagen2JPG(bfImgGris);
                imgJPG.guardarImagen("ImgProcesado/WonderWoman.pgm");
                // Aplica Cany
                Canny bordeCanny = new Canny();
                bordeCanny.calculoCanny(imgJPG, 3);
                Imagen imgCanny = bordeCanny.getImagen();
                imgCanny.guardarImagen("ImgProcesado/WonderWomanCanny.pgm");
            } catch (IOException ex) {
                System.err.println("Error: Procesa JPG error al leer archivo");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error: Procesa JPG error al abrir archivo");
        }
    }
    
    public static Imagen getImagen2JPG(BufferedImage bfImg) {
        Imagen imgJPG = new Imagen();
        // Objeto que contiene la matriz de pixeles
        Raster raster = bfImg.getData();
        int bandas = raster.getNumBands();
        if (bandas == 1) {
            int alto = raster.getHeight();
            int ancho = raster.getWidth();
            int minX = raster.getMinX();
            int minY = raster.getMinY();
            imgJPG.setFormato("P2");
            imgJPG.setM(ancho);
            imgJPG.setN(alto);
            imgJPG.setNivelIntensidad(255);
            short matrizGris[][] = new short[alto][ancho];
            for (int i = minY; i < alto; i++) {
                for (int j = minX; j < ancho; j++) {
                    short pixel = (short) raster.getSample(j, i, 0);
                    matrizGris[i][j] = pixel;
                }
            }
            imgJPG.setMatrizGris(matrizGris);
        }
        return imgJPG;
    }
}
