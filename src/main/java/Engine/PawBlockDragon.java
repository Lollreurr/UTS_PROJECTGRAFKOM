package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class PawBlockDragon extends OvalBlockDragon{

    float radiusZ;
    List<Integer> pascal;
    List<Vector3f> curve;
    List<Vector3f> tempVer;
    int vboCurve;

    public PawBlockDragon(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint,
                          float rX, float rY, float rZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.radiusZ = rZ;
        this.curve = new ArrayList<>(List.of());
        this.pascal = new ArrayList<>(List.of());
        this.tempVer = new ArrayList<>(List.of());
        createBox();
        setupVAOVBO();
    }

    public void createPascal(){
        pascal.clear();
        int value;
        int baseFac = 1;
        for (int i=1; i<tempVer.size(); i++){
            baseFac = baseFac * i;
        }

        pascal.add(1);

        for (int i=1; i<tempVer.size(); i++){
            if (i == tempVer.size() - 1){
                pascal.add(1);
                break;
            }

            int secFac = 1;
            for (int j = i; j>0; j--) {
                secFac = secFac * j;
            }

            int thirdFac = 1;
            for (int j = tempVer.size()-1 - i; j>0; j--){
                thirdFac = thirdFac * j;
            }

            //C(n, r) = n! / (r! * (n - r)!)
            value = baseFac / (secFac * (thirdFac));

            pascal.add(value);
        }
    }

    public void createCurve(){
        curve.clear();
        createPascal();
        float y,z, count;

        for (double i=0; i<1; i+=0.001) {
            y = 0;
            z = 0;
            for (double j = 0; j < tempVer.size(); j++) {
                //P(Pawt) = (1-t)^5 v1 + 5 (1-t)^4 t v2 + 10 (1-t)^3 t^2 v3 + 10 (1-t)^2 t^3 v4 + 5 (1-t) t^4 v5 + t^5 v6
                count = (float) pascal.get((int)j) * (float) Math.pow((1-i), tempVer.size()-1 - j) * (float) Math.pow(i, j);

                y += tempVer.get((int)j).y * count;
                z += tempVer.get((int)j).z * count;
            }
            curve.add(new Vector3f(centerPoint.x, y, z));
        }
    }


    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //Titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 2 kiri bawah belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 4 kanan atas belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 5 kiri atas depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 6 kiri bawah depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 7 kanan bawah depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 8 kiri atas depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);

        tempVer.add(tempVertices.get(0));
        tempVer.add(tempVertices.get(4));
        tempVer.add(tempVertices.get(5));
        createCurve();

        for (Vector3f vec:curve){
            vertices.add(new Vector3f((vec.x - radiusX/2), vec.y, vec.z));
            vertices.add(new Vector3f((vec.x + radiusX/2), vec.y, vec.z));
        }

        for (Vector3f vec:curve){
            vertices.add(new Vector3f((vec.x - radiusX/2), vec.y, vec.z));
            vertices.add(tempVertices.get(1));
        }
        for (Vector3f vec:curve){
            vertices.add(new Vector3f((vec.x + radiusX/2), vec.y, vec.z));
            vertices.add(tempVertices.get(2));
        }

//        for (int i=0; i<curve.size(); i++){
//            vertices.add(curve.get(i));
//            vertices.add(new Vector3f((curve.get(i).x + radiusX), (curve.get(i).y), (curve.get(i).z)));
//        }
//
//        for (int i=0; i<curve.size(); i++){
//            vertices.add(curve.get(i));
//            vertices.add(tempVertices.get(1));
//        }
//
//        for (int i=0; i<curve.size(); i++){
//            vertices.add(new Vector3f((curve.get(i).x + radiusX), (curve.get(i).y), (curve.get(i).z)));
//            vertices.add(tempVertices.get(2));
//        }
//
        while (true) {
            if (vertices.size() % 3 != 0) {
                vertices.add(tempVertices.get(2));
            }
            else{
                break;
            }
        }


        // kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
    }


//    public void draw() {
//        drawSetup();
//        // Draw the vertices
//        //optional
//        glDrawArrays(GL_TRIANGLES, 0,
//                vertices.size());
//    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_POLYGON,0,
                vertices.size());
        for(ObjectBlockDragon child:childObject){
            child.draw(camera, projection);
        }
    }

}
