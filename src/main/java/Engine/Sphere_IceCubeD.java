package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere_IceCubeD extends Circle_IceCubeD {
    float radiusZ;
    int stackCount;
    int sectorCount;
    List<Integer> index;
    int ibo;
    public Sphere_IceCubeD(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                           int sectorCount, int stackCount, int index) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        if (index == 0){
            createSphere_bola();
        } else if (index == 1) {
            createBox();
        } else if (index == 2) {
            createEllipsoid_hand();
        } else if (index == 3) {
            createTube_sleep();
        } else if (index == 4) {
            createTube_stand();
        } else if (index == 5) {
            createEllipticParaboloid();
        } else if (index == 6) {
            createEllipticParaboloid_jariT();
        } else if (index == 7) {
            createEllipticParaboloid_jariK();
        } else if (index == 8) {
            createSphere();
        }

        setupVAOVBO();
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
    //Titik 4 kiri atas belakang
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
    temp = new Vector3f();

    // kotak belakang
    vertices.add(tempVertices.get(0));
    vertices.add(tempVertices.get(1));
    vertices.add(tempVertices.get(2));

    vertices.add(tempVertices.get(2));
    vertices.add(tempVertices.get(3));
    vertices.add(tempVertices.get(0));

    // kotak depan
    vertices.add(tempVertices.get(4));
    vertices.add(tempVertices.get(5));
    vertices.add(tempVertices.get(6));

    vertices.add(tempVertices.get(6));
    vertices.add(tempVertices.get(7));
    vertices.add(tempVertices.get(4));

    // kotak samping kiri
    vertices.add(tempVertices.get(0));
    vertices.add(tempVertices.get(1));
    vertices.add(tempVertices.get(5));

    vertices.add(tempVertices.get(5));
    vertices.add(tempVertices.get(4));
    vertices.add(tempVertices.get(0));

    // kotak samping kanan
    vertices.add(tempVertices.get(3));
    vertices.add(tempVertices.get(2));
    vertices.add(tempVertices.get(6));

    vertices.add(tempVertices.get(6));
    vertices.add(tempVertices.get(7));
    vertices.add(tempVertices.get(3));

    // kotak atas
    vertices.add(tempVertices.get(0));
    vertices.add(tempVertices.get(4));
    vertices.add(tempVertices.get(7));

    vertices.add(tempVertices.get(7));
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

//    public void draw(Camera camera, Projection projection){
//        drawSetup(camera, projection);
//        glLineWidth(1); //ketebalan garis
//        glPointSize(1); //besar kecil vertex
//        glDrawArrays(GL_TRIANGLE_FAN,
//                0,
//                vertices.size());
//    }
    public void draw_indices(){
//        drawSetup();
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void createSphere(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //hyperboloid paraboloid
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = -0.455f * (float)(v * Math.sin(u)/Math.cos(u));
//                float y = 0.35f * (float)(v *1/ Math.cos(u));
//                float z = -0.35f * (float)(v*v);
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        //eliptic cone
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.455f * (float)(v * Math.cos(u));
//                float y = 0.35f * (float)(v * Math.sin(u));
//                float z = 0.35f * (float)(v);
//                temp.add(new Vector3f(x,z,y));
//            }
//        }

        //ellipsoid
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = -0.455f * (float)(Math.cos(v) * Math.cos(u));
//                float y = 0.35f * (float)(Math.cos(v) * Math.sin(u));
//                float z = -0.35f * (float)(Math.sin(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }

        //bola
//        int stackCount = 18, sectorCount = 36;
//        float x,y,z,xy,nx,ny,nz;
//        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
//        float stackStep = (float)Math.PI / stackCount; // stack count
//        float sectorAngle, stackAngle;
//
//        //titik persegi
//        for(int i=0;i<=stackCount;i++){
//            stackAngle = (float)Math.PI/2 - i * stackStep;
//            xy = (float) (0.1f * Math.cos(stackAngle));
//            z = (float) (0.1f * Math.sin(stackAngle));
//            for(int j=0;j<sectorCount;j++){
//                sectorAngle = j * sectorStep;
//                x = (float) (xy * Math.cos(sectorAngle));
//                y = (float) (xy * Math.sin(sectorAngle));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/20){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/20){
                float x = 0.1f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.1f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }

//        ArrayList<Vector3f> temp = new ArrayList<>();
//        int stackCount = 18, sectorCount = 36;
//        float x,y,z,xy,nx,ny,nz;
//        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
//        float stackStep = (float)Math.PI / stackCount; // stack count
//        float sectorAngle, stackAngle;
//
//        for(int i=0;i<=stackCount;i++){
//            stackAngle = (float)Math.PI/2 - i * stackStep;
//            xy = (float) (0.5f * Math.cos(stackAngle));
//            z = (float) (0.5f * Math.sin(stackAngle));
//            for(int j=0;j<sectorCount;j++){
//                sectorAngle = j * sectorStep;
//                x = (float) (xy * Math.cos(sectorAngle));
//                y = (float) (xy * Math.sin(sectorAngle));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createSphere_bola(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //bola
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        //titik persegi
        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.1f * Math.cos(stackAngle));
            z = (float) (0.1f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createEllipsoid_hand(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //ellipsoid
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.13f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.3f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.12f * (float)(Math.sin(v));
                temp.add(new Vector3f(z,y,x));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createTube_sleep(){
        vertices.clear();
        float x,y1, y2,z = 0;
        for (double i = 0; i < 360; i += 360 / 360) {
            x = (float) (centerPoint.x + radiusX * Math.cos(i));
            y1 = (centerPoint.y + (radiusY / 2));
            y2 = (centerPoint.y - (radiusY / 2));
            z = (float) (centerPoint.z + radiusZ * Math.sin(i));
            vertices.add(new Vector3f(x,z,y1));
            vertices.add(new Vector3f(x,z,y2));
        }

        for (int i=0; i<360; i+= 360/360){
            vertices.add(vertices.get(i));
            vertices.add(vertices.get(i+360));
        }
    }
    public void createTube_stand(){
        vertices.clear();
        float x,y1, y2,z = 0;
        for (double i = 0; i < 360; i += 360 / 360) {
            x = (float) (centerPoint.x + radiusX * Math.cos(i));
            y1 = (centerPoint.y + (radiusY / 2));
            y2 = (centerPoint.y - (radiusY / 2));
            z = (float) (centerPoint.z + radiusZ * Math.sin(i));
            vertices.add(new Vector3f(x,y1,z));
            vertices.add(new Vector3f(x,y2,z));
        }

        for (int i=0; i<360; i+= 360/360){
            vertices.add(vertices.get(i));
            vertices.add(vertices.get(i+360));
        }
    }
    public void createEllipticParaboloid_jariT(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //eliptic paraboloid
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)(v * Math.cos(u));
                float y = 0.1f * (float)(v * Math.sin(u));
                float z = (float) Math.pow((float)(v),2);
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }
    public void createEllipticParaboloid_jariK(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //eliptic paraboloid
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)(v * Math.cos(u));
                float y = 0.1f * (float)(v * Math.sin(u));
                float z = (float) Math.pow((float)(v),2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createEllipticParaboloid(){
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        //eliptic paraboloid
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)(v * Math.cos(u));
                float y = 0.1f * (float)(v * Math.sin(u));
                float z = (float) Math.pow((float)(v),2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }


}

//package Engine;
//
//import org.joml.Vector3f;
//import org.joml.Vector4f;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.opengl.GL11.GL_POLYGON;
//
//public class Sphere extends Circle{
//    float radiusZ;
//    int stackCount;
//    int sectorCount;
//    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
//                  int sectorCount,int stackCount, int index) {
//        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
//        this.radiusZ = radiusZ;
//        this.stackCount = stackCount;
//        this.sectorCount = sectorCount;
//        if (index == 0){
//            createSphere();
//        } else if (index == 1) {
//            createBox();
//        }
////        createBox();
////        createSphere();
//        setupVAOVBO();
//    }
//    public void createBox(){
//        Vector3f temp = new Vector3f();
//        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        //TITIK 1
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 2
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 3
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 4
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 5
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 6
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 7
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 8
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        vertices.clear();
//        //kotak yg sisi belakang
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(3));
//        //kotak yg sisi depan
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(7));
//        //kotak yg sisi kiri
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(3));
//        //kotak yg sisi kanan
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(2));
//        //kotak yg sisi atas
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(4));
//        //kotak yg sisi bawah
//        vertices.add(tempVertices.get(3));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(6));
//    }
////    public void draw(Camera camera, Projection projection){
////        drawSetup(camera, projection);
////        glLineWidth(2); //ketebalan garis
////        glPointSize(2); //besar kecil vertex
////        glDrawArrays(GL_LINE_STRIP,
////                0,
////                vertices.size());
////    }
//    public void createSphere(){
//        float pi = (float)Math.PI;
//
//        float sectorStep = 2 * (float)Math.PI / sectorCount;
//        float stackStep = (float)Math.PI / stackCount;
//        float sectorAngle, StackAngle, x, y, z;
//
//        for (int i = 0; i <= stackCount; ++i)
//        {
//            StackAngle = pi / 2 - i * stackStep;
//            x = radiusX * (float)Math.cos(StackAngle);
//            y = radiusY * (float)Math.cos(StackAngle);
//            z = radiusZ * (float)Math.sin(StackAngle);
//
//            for (int j = 0; j <= sectorCount; ++j)
//            {
//                sectorAngle = j * sectorStep;
//                Vector3f temp_vector = new Vector3f();
//                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
//                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
//                temp_vector.z = centerPoint.get(2) + z;
//                vertices.add(temp_vector);
//            }
//        }
//    }
//}