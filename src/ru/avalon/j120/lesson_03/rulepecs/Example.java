package ru.avalon.j120.lesson_03.rulepecs;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<Country> list = new ArrayList<>();

        list.add(new District());
        list.add(new District());
        list.add(new District());
        list.add(new District());
        list.add(new District());

        list.add(new Street());
        list.add(new Street());
        list.add(new Street());
        list.add(new Street());

        list.add(new Country());
        list.add(new Country());
        list.add(new Country());


        list.add(new City());
        list.add(new City());
        list.add(new City());
        list.add(new City());
        list.add(new City());
        list.add(new City());


        Example ex = new Example();
        ex.setListConsumer(list);
//        ex.setListProducer(list);



    }

    public void setListProducer(List<? extends District> list) {
        District d = list.get(0);
        City c = list.get(0);
    }

    public void setListConsumer(List<? super District> list) {
        Object obj = list.get(0);

        /*

        System.out.println("Приводимость к Country: " + (obj instanceof Country));
        System.out.println("Приводимость к City: " + (obj instanceof City));
        System.out.println("Приводимость к District: " + (obj instanceof District));
        System.out.println("Приводимость к Street: " + (obj instanceof Street));

         */

        List<Street> streetList = new ArrayList<>();
        List<District> districtList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();

        for (Object o : list) {
            if (o instanceof Street)
                streetList.add((Street) o);
            else if (o instanceof District)
                districtList.add((District) o);
            else if (o instanceof City)
                cityList.add((City) o);
            else if (o instanceof Country)
                countryList.add((Country) o);
        }

        System.out.println("CountryList length " + countryList.size());
        System.out.println("CityList length " + cityList.size());
        System.out.println("DistrictList length " + districtList.size());
        System.out.println("StreetList length " + streetList.size());

    }

}
