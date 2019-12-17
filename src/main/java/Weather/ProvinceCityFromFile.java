package Weather;

import hibernate.ProvinceCity;
import hibernate.ProvinceCityDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProvinceCityFromFile {
    public static void listamiast(String cityName) throws FileNotFoundException {
        ArrayList<String> listamiast = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź miasto, a dowiesz się w jakim się znajduje województwie");



        File plik = new File("C:\\Users\\pawel\\Desktop\\Wyjazdy\\src\\main\\java\\Weather\\places.txt");
        ProvinceCity provinceCity = new ProvinceCity(cityName, null);
        Scanner odczyt = new Scanner(plik);
        for (int i = 0; i <2327 ; i++) {


            String text = odczyt.nextLine();

            if ( text.endsWith(cityName)) {
                if(i<156) {
                    provinceCity.setProvince("Dolnośląskie");

                    break;
                }
                else if(i<286) {
                    provinceCity.setProvince("Kujawsko Pomorskie");
                    break;
                }
                else if(i<481) {
                    provinceCity.setProvince("Lubelskie");
                    break;
                }
                else if(i<559) {
                    provinceCity.setProvince("Lubuskie");
                    break;
                }
                else if(i<721) {
                    provinceCity.setProvince("Lodzkie");
                    break;
                }
                else if(i<893) {
                    provinceCity.setProvince("Malopolskie");
                    break;
                }
                else if(i<1208) {
                    provinceCity.setProvince("Mazowieckie");
                    break;
                }
                else if(i<1279) {
                    provinceCity.setProvince("Opolskie");
                    break;
                }
                else if(i<1425) {
                    provinceCity.setProvince("Podkarpackie");
                    break;
                }
                else if(i<1531) {
                    provinceCity.setProvince("Podlaskie");
                    break;
                }
                else if(i<1641) {
                    provinceCity.setProvince("Pomorskie");
                    break;
                }
                else if(i<1818) {
                    provinceCity.setProvince("Slaskie");
                    break;
                }
                else if(i<1909) {
                    provinceCity.setProvince("Swietokrzyskie");
                    break;
                }
                else if(i<2008) {
                    provinceCity.setProvince("Warminsko-Mazurskie");
                }
                else if(i<2223) {
                    provinceCity.setProvince("Wielkopolskie");
                    break;
                }
                else if(i<2328) {
                    provinceCity.setProvince("Zachodnio-Pomorskie");
                    break;
                }


            }

        }
        ProvinceCityDao provinceCityDao = new ProvinceCityDao();
        provinceCityDao.saveObject(provinceCity);
        System.out.println(provinceCity);

    }
}

