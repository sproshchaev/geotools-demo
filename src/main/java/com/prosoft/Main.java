package com.prosoft;

import org.geotools.data.*;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.feature.simple.SimpleFeatureType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * geotools-demo
 */
public class Main {
    public static void main(String[] args) throws IOException, SchemaException {

        // Creating
        FileDataStoreFactorySpi factory = new ShapefileDataStoreFactory();
        File file = new File("my.shp");
        Map<String, ?> map = Collections.singletonMap("url", file.toURI().toURL());
        DataStore myData = factory.createNewDataStore(map);
        SimpleFeatureType featureType = DataUtilities.createType("my", "geom:Point,name:String,age:Integer,description:String");
        myData.createSchema(featureType);



        System.out.println("Done!");
    }
}
