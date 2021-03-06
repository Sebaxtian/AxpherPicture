/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

/**
 * Esta clase permite calcular el umbral
 * para un histograma de alguna imagen,
 * esta clase tiene diferentes metodos
 * para realizar el calculo del umbral.
 * 
 * @author Juan Sebastian Rios Sabogal
 * @Fecha mar abr  3 14:15:51 COT 2012
 * @version 0.1
 */


public class Umbralizacion {
    
    //Atributos de clase
    private Histograma histograma;
    private int umbralGris;
    private int umbralR;
    private int umbralG;
    private int umbralB;
    
    public Umbralizacion(Histograma histograma, int metodo) {
        this.histograma = histograma;
        calcularUmbral(metodo);
    }
    
    private void calcularUmbral(int metodo) {
        if(metodo == 0) {
            metodoDosPicos();
        }else if (metodo == 1){
            metodoIsodata();
        }
        else if(metodo == 2){
            metodoOtsu();
        }
        
    }
    
    private void metodoDosPicos() {
        String formato = histograma.getFormato();
        if(formato.equals("P2")) {
            int histogramaGris[] = histograma.getHistogramaGris();
            int pixelesPico1 = histograma.getMaxNumPixelesGris();
            int nivelPico1 = histograma.getNivelDominanteGris();
            int pixelesPico2 = 0;
            int nivelPico2 = 0;
            //busca el segundo pico mas alto y lejano al pico 1
            int normalPicos[] = new int[histogramaGris.length];
            for(int n = 0; n < normalPicos.length; n++) {
                normalPicos[n] = (int)Math.pow((n - nivelPico1), 2) * histogramaGris[n];
            }
            for(int j = 0; j < normalPicos.length; j++) {
                if(normalPicos[j] > pixelesPico2) {
                    pixelesPico2 = normalPicos[j];
                    nivelPico2 = j;
                }
            }
            //busca el pico mas bajo entre los dos picos (umbral)
            int picoBajo = pixelesPico1+pixelesPico2;
            if(nivelPico1 > nivelPico2) {
                for(int i = nivelPico2; i < nivelPico1; i++) {
                    if(histogramaGris[i] < picoBajo && histogramaGris[i] > 0) {
                        picoBajo = histogramaGris[i];
                        umbralGris = (short)i;
                    }
                }
            } else {
                for(int i = nivelPico1; i < nivelPico2; i++) {
                    if(histogramaGris[i] < picoBajo && histogramaGris[i] > 0) {
                        picoBajo = histogramaGris[i];
                        umbralGris = (short)i;
                    }
                }
            }
        }
        if(formato.equals("P3")) {
            int histogramaR[] = histograma.getHistogramaR();
            int histogramaG[] = histograma.getHistogramaG();
            int histogramaB[] = histograma.getHistogramaB();
            //canal R
            int pixelesPico1R = histograma.getMaxNumPixelesR();
            int nivelPico1R = histograma.getNivelDominanteR();
            int pixelesPico2R = 0;
            int nivelPico2R = 0;
            //canal G
            int pixelesPico1G = histograma.getMaxNumPixelesG();
            int nivelPico1G = histograma.getNivelDominanteG();
            int pixelesPico2G = 0;
            int nivelPico2G = 0;
            //canal B
            int pixelesPico1B = histograma.getMaxNumPixelesB();
            int nivelPico1B = histograma.getNivelDominanteB();
            int pixelesPico2B = 0;
            int nivelPico2B = 0;
            //busca el segundo pico mas alto y lejano al pico 1 para cada canal RGB
            int normalPicosR[] = new int[histogramaR.length];
            int normalPicosG[] = new int[histogramaG.length];
            int normalPicosB[] = new int[histogramaB.length];
            for(int n = 0; n < normalPicosR.length; n++) {
                normalPicosR[n] = (int)Math.pow((n - nivelPico1R), 2) * histogramaR[n];
                normalPicosG[n] = (int)Math.pow((n - nivelPico1G), 2) * histogramaG[n];
                normalPicosB[n] = (int)Math.pow((n - nivelPico1B), 2) * histogramaB[n];
            }
            for(int j = 0; j < normalPicosR.length; j++) {
                //canal R
                if(normalPicosR[j] > pixelesPico2R) {
                    pixelesPico2R = normalPicosR[j];
                    nivelPico2R = j;
                }
                //canal G
                if(normalPicosG[j] > pixelesPico2G) {
                    pixelesPico2G = normalPicosG[j];
                    nivelPico2G = j;
                }
                //canal B
                if(normalPicosB[j] > pixelesPico2B) {
                    pixelesPico2B = normalPicosB[j];
                    nivelPico2B = j;
                }
            }
            //busca el pico mas bajo entre los dos picos (umbral) para cada canal RGB
            int picoBajoR = pixelesPico1R+pixelesPico2R;
            int picoBajoG = pixelesPico1G+pixelesPico2G;
            int picoBajoB = pixelesPico1B+pixelesPico2B;
            //canal R
            if(nivelPico1R > nivelPico2R) {
                for(int i = nivelPico2R; i < nivelPico1R; i++) {
                    if(histogramaR[i] < picoBajoR && histogramaR[i] > 0) {
                        picoBajoR = histogramaR[i];
                        umbralR = (short)i;
                    }
                }
            } else {
                for(int i = nivelPico1R; i < nivelPico2R; i++) {
                    if(histogramaR[i] < picoBajoR && histogramaR[i] > 0) {
                        picoBajoR = histogramaR[i];
                        umbralR = (short)i;
                    }
                }
            }
            //cana G
            if(nivelPico1G > nivelPico2G) {
                for(int i = nivelPico2G; i < nivelPico1G; i++) {
                    if(histogramaG[i] < picoBajoG && histogramaG[i] > 0) {
                        picoBajoG = histogramaG[i];
                        umbralG = (short)i;
                    }
                }
            } else {
                for(int i = nivelPico1G; i < nivelPico2G; i++) {
                    if(histogramaG[i] < picoBajoG && histogramaG[i] > 0) {
                        picoBajoG = histogramaG[i];
                        umbralG = (short)i;
                    }
                }
            }
            //canal B
            if(nivelPico1B > nivelPico2B) {
                for(int i = nivelPico2B; i < nivelPico1B; i++) {
                    if(histogramaB[i] < picoBajoB && histogramaB[i] > 0) {
                        picoBajoB = histogramaB[i];
                        umbralB = (short)i;
                    }
                }
            } else {
                for(int i = nivelPico1B; i < nivelPico2B; i++) {
                    if(histogramaB[i] < picoBajoB && histogramaB[i] > 0) {
                        picoBajoB = histogramaB[i];
                        umbralB = (short)i;
                    }
                }
            }
        }
    }

    public void metodoIsodata() {
        String formato = histograma.getFormato(); 
        if(formato.equals("P2")) {
            this.umbralGris = 0;
            int histogramaGris[] = this.histograma.getHistogramaGris();
            int t = 0, PixelesFi = 0;

            int Size = histogramaGris.length, TotalPixels = 0;
            int PixelsBackGround, PixelsForeground, TotalPixelsBg, TotalPixelsFg;

            for (int i = 0; i < Size; i++) {
                PixelesFi += i * histogramaGris[i];
                TotalPixels += histogramaGris[i];
            }
            this.umbralGris = PixelesFi / TotalPixels;

            while (true) {
                PixelsBackGround = 0;
                TotalPixelsBg = 0;
                PixelsForeground = 0;
                TotalPixelsFg = 0;

                for (int i = 0; i < this.umbralGris; i++) {
                    PixelsBackGround += i * histogramaGris[i];
                    TotalPixelsBg += histogramaGris[i];
                }
                PixelsForeground = PixelesFi - PixelsBackGround;
                TotalPixelsFg = TotalPixels - TotalPixelsBg;

                t = (PixelsBackGround / TotalPixelsBg) + (PixelsForeground / TotalPixelsFg);
                t /= 2;

                if (this.umbralGris == t) {
                    break;
                } else {
                    this.umbralGris = t;
                }
            }
        }else if(formato.equals("P3")) {
            //Calculo para el umbral del histograma con el color blue
            this.umbralB = 0;
            int histogramaB[] = this.histograma.getHistogramaB();
            int t = 0, PixelesFi = 0;

            int Size = histogramaB.length, TotalPixels = 0;
            int PixelsBackGround, PixelsForeground, TotalPixelsBg, TotalPixelsFg;

            for (int i = 0; i < Size; i++) {
                PixelesFi += i * histogramaB[i];
                TotalPixels += histogramaB[i];
            }
            this.umbralB = PixelesFi / TotalPixels;

            while (true) {
                PixelsBackGround = 0;
                TotalPixelsBg = 0;
                PixelsForeground = 0;
                TotalPixelsFg = 0;

                for (int i = 0; i < this.umbralB; i++) {
                    PixelsBackGround += i * histogramaB[i];
                    TotalPixelsBg += histogramaB[i];
                }
                PixelsForeground = PixelesFi - PixelsBackGround;
                TotalPixelsFg = TotalPixels - TotalPixelsBg;

                t = (PixelsBackGround / TotalPixelsBg) + (PixelsForeground / TotalPixelsFg);
                t /= 2;

                if (this.umbralB == t) {
                    break;
                } else {
                    this.umbralB = t;
                }
            }
            
            //Calculo para el umbral del histograma con el color GREEN
            this.umbralG = 0;
            int histogramaG[] = this.histograma.getHistogramaG();
            
            t = 0;
            PixelesFi = 0;

            Size = histogramaG.length;
            TotalPixels = 0;
            
            for (int i = 0; i < Size; i++) {
                PixelesFi += i * histogramaB[i];
                TotalPixels += histogramaB[i];
            }
            
            this.umbralG = PixelesFi / TotalPixels;

            while (true) {
                PixelsBackGround = 0;
                TotalPixelsBg = 0;
                PixelsForeground = 0;
                TotalPixelsFg = 0;

                for (int i = 0; i < this.umbralG; i++) {
                    PixelsBackGround += i * histogramaG[i];
                    TotalPixelsBg += histogramaG[i];
                }
                PixelsForeground = PixelesFi - PixelsBackGround;
                TotalPixelsFg = TotalPixels - TotalPixelsBg;

                t = (PixelsBackGround / TotalPixelsBg) + (PixelsForeground / TotalPixelsFg);
                t /= 2;

                if (this.umbralG == t) {
                    break;
                } else {
                    this.umbralG = t;
                }
            }
            //
            //Calculo para el umbral del histograma con el color RED
            this.umbralR = 0;
            int histogramaR[] = this.histograma.getHistogramaR();
            
            t = 0;
            PixelesFi = 0;

            Size = histogramaB.length;
            TotalPixels = 0;

            for (int i = 0; i < Size; i++) {
                PixelesFi += i * histogramaR[i];
                TotalPixels += histogramaR[i];
            }
            this.umbralR = PixelesFi / TotalPixels;

            while (true) {
                PixelsBackGround = 0;
                TotalPixelsBg = 0;
                PixelsForeground = 0;
                TotalPixelsFg = 0;

                for (int i = 0; i < this.umbralR; i++) {
                    PixelsBackGround += i * histogramaR[i];
                    TotalPixelsBg += histogramaR[i];
                }
                PixelsForeground = PixelesFi - PixelsBackGround;
                TotalPixelsFg = TotalPixels - TotalPixelsBg;

                t = (PixelsBackGround / TotalPixelsBg) + (PixelsForeground / TotalPixelsFg);
                t /= 2;

                if (this.umbralR == t) {
                    break;
                } else {
                    this.umbralR = t;
                }
            }
        }else{
            System.out.println("UPS que formato sera "+formato );
        }
    }
    
    
    public void metodoOtsu() {
        String formato = histograma.getFormato();
        if (formato.equals("P2")) {
            int histogramaGris[] = this.histograma.getHistogramaGris();
            int Size = histogramaGris.length;
            int total = 0;

            for (int i = 0; i < Size; i++) {
                total += histogramaGris[i];
            }

            float wb = 0, wf = 0;//frecuencias de background y foreground
            this.umbralGris = 0;//valor umbral
            double Maximo = 0, temp = 0, Sum = 0, sum = 0;
            double mb = 0, mf = 0;

            for (int i = 0; i < Size; i++) {
                Sum += i * histogramaGris[i];
            }
            for (int t = 0; t < Size; t++) {
                wb += histogramaGris[t];
                if (wb == 0) {
                    continue;
                }


                wf = total - wb;
                if (wf == 0) {
                    break;
                }


                sum += t * histogramaGris[t];

                mb = sum / wb;
                mf = (Sum - sum) / wf;

                temp = wb * wf * Math.pow(mb - mf, 2);

                if (temp > Maximo) {

                    Maximo = temp;
                    this.umbralGris = t;
                }
            }

        }else if(formato.equals("P3")) {
            //calculo para el canal canal R
            int histogramaR[] = this.histograma.getHistogramaR();
            int Size = histogramaR.length;
            int total = 0;

            for (int i = 0; i < Size; i++) {
                total += histogramaR[i];
            }

            float wb = 0, wf = 0;//frecuencias de background y foreground
            this.umbralR = 0;//valor umbral
            double Maximo = 0, temp = 0, Sum = 0, sum = 0;
            double mb = 0, mf = 0;

            for (int i = 0; i < Size; i++) {
                Sum += i * histogramaR[i];
            }
            for (int t = 0; t < Size; t++) {
                wb += histogramaR[t];
                if (wb == 0) {
                    continue;
                }


                wf = total - wb;
                if (wf == 0) {
                    break;
                }


                sum += t * histogramaR[t];

                mb = sum / wb;
                mf = (Sum - sum) / wf;

                temp = wb * wf * Math.pow(mb - mf, 2);

                if (temp > Maximo) {

                    Maximo = temp;
                    this.umbralR = t;
                }
            }
            //calculo para el canal canal G
            int histogramaG[] = this.histograma.getHistogramaG();
            Size = histogramaG.length;
            total = 0;

            for (int i = 0; i < Size; i++) {
                total += histogramaG[i];
            }

            wb = 0; wf = 0;//frecuencias de background y foreground
            this.umbralG = 0;//valor umbral
            Maximo = 0; temp = 0; Sum = 0; sum = 0;
            mb = 0; mf = 0;

            for (int i = 0; i < Size; i++) {
                Sum += i * histogramaG[i];
            }
            for (int t = 0; t < Size; t++) {
                wb += histogramaG[t];
                if (wb == 0) {
                    continue;
                }


                wf = total - wb;
                if (wf == 0) {
                    break;
                }


                sum += t * histogramaG[t];

                mb = sum / wb;
                mf = (Sum - sum) / wf;

                temp = wb * wf * Math.pow(mb - mf, 2);

                if (temp > Maximo) {

                    Maximo = temp;
                    this.umbralG = t;
                }
            }
            //calculo para el canal canal B
            int histogramaB[] = this.histograma.getHistogramaB();
            Size = histogramaB.length;
            total = 0;

            for (int i = 0; i < Size; i++) {
                total += histogramaB[i];
            }

            wb = 0; wf = 0;//frecuencias de background y foreground
            this.umbralB = 0;//valor umbral
            Maximo = 0; temp = 0; Sum = 0; sum = 0;
            mb = 0; mf = 0;

            for (int i = 0; i < Size; i++) {
                Sum += i * histogramaB[i];
            }
            for (int t = 0; t < Size; t++) {
                wb += histogramaB[t];
                if (wb == 0) {
                    continue;
                }


                wf = total - wb;
                if (wf == 0) {
                    break;
                }


                sum += t * histogramaB[t];

                mb = sum / wb;
                mf = (Sum - sum) / wf;

                temp = wb * wf * Math.pow(mb - mf, 2);

                if (temp > Maximo) {

                    Maximo = temp;
                    this.umbralB = t;
                }
            }
        }
    }
    
    
    public int getUmbralGris() {
        return umbralGris;
    }
    
    public int getUmbralR() {
        return umbralR;
    }
    
    public int getUmbralG() {
        return umbralG;
    }
    
    public int getUmbralB() {
        return umbralB;
    }
}
