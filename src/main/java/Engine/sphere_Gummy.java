package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class sphere_Gummy extends Circle2_Gummy {
    float radiusZ;
    int sectorCount;
    int stackCount;
    int count = 3;
    int temp;
    private ArrayList<Object2d_Gummy> titikBerzier = new ArrayList<>();

    public sphere_Gummy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, float radiusX, float radiusY, float radiusZ, int sectorCount, int stackCount,
                        int opsi) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;

//        createHyperboloid2sheet1(); //create hyperboloid 2 side
//        createHyperboloid2sheet2();
//        createHyperboloid1(); //hyperboloid 1 side
//        createEllipsoid(); //elipsoid

        if (opsi == 1) {
            createEllipsoid();
        }
        if (opsi == 2) {
            createHand();
        }
        if (opsi == 3) {
            elipticParaboloid();
        }
        if (opsi == 4) {
            elipticCone();
        }
        if (opsi == 5) {
            createTriangle();
        }
        if (opsi == 6) {
            createTube();
        }
        if (opsi == 7) {
            createTubeSleep();
        }
        if (opsi == 8) {
            createBox();
        }
        if (opsi == 9) {
            createWing();
        }
        if (opsi == 10) {
            createBezier();
        }
        if (opsi == 11){
            createBox();
        }


//        createCircle();
        setupVAOVBO();
    }

    public int factorial(int angka) {
        int hasil = 1;
        for (int i = 2; i <= angka; i++) {
            hasil = hasil * i;
        }
        return hasil;
    }

    public int kombinasi(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public void createBezier() {
        temp =0;


        for (float u = 0; u <= 1; u += 0.01f) {
            float tempx = 0;
            float tempy = 0;
            float tempz = 0;
            for (int i = 0; i < count; i++) {
                int temp1 = kombinasi(3, i);
                float temp2 = temp1 * (float) Math.pow(1 - u, count - i) * (float) Math.pow(u, i);
                tempx += temp2 * (radiusX );
                tempy += temp2 * (radiusY );
                tempz += temp2 * (radiusZ +0.1f);

            }
         vertices.add(new Vector3f(tempx,tempy,tempz));
        }

        for (float u = 0; u <= 1; u += 0.01f) {
            float tempx = 0;
            float tempy = 0;
            float tempz = 0;
            for (int i = 0; i < count; i++) {
                int temp1 = kombinasi(3, i);
                float temp2 = temp1 * (float) Math.pow(1 - u, count - i) * (float) Math.pow(u, i);
                tempx = temp2 * (radiusX - 0.3f );
                tempy = temp2 * (radiusY + 0.1f);
                tempz += temp2 * (radiusZ +0.1f) ;
            }
            vertices.add(new Vector3f(tempx,tempy,tempz));



        }

        for (float u = 0; u <= 1; u += 0.01f) {
            float tempx = 0;
            float tempy = 0;
            float tempz = 0;
            for (int i = 0; i < count; i++) {
                int temp1 = kombinasi(3, i);
                float temp2 = temp1 * (float) Math.pow(1 - u, count - i) * (float) Math.pow(u, i);
                tempx = temp2 * (radiusX - 0.2f);
                tempy = temp2 * radiusY;
                tempz += temp2 * (radiusZ + 0.1f);
            }
            vertices.add(new Vector3f(tempx,tempy,tempz));

        }

    }


    public void createWing(){
        Vector3f temp = new Vector3f();

        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        //bagian depan
        //0
        temp.x = (centerPoint.get(0) - 0.1f)  - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.1f) + radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //1
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.6f) + radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //2
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.1f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.1f) +radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //3
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.2f)+ radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //4
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.0f) + radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //5

        //6
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.5f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //7
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.2f) - radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //8
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.2f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.3f) - radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //9
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.0f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.2f)- radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //10
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.4f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.3f) - radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //11
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.2f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);
        //12
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.6f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) +0.1f) + radiusX / 2.0f;
        temp.z = centerPoint.get(0) + radiusX / 2.0f;
        tempVertices.add(temp);

        //bagian belakang

        //13
        temp.x = (centerPoint.get(0) - 0.1f)  - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.1f) + radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //14
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.6f) + radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //15
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.1f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.1f) +radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //16
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.2f)+ radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //17
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) + 0.0f) + radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);

        //19
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.5f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //20
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.3f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.2f) - radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //21
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.2f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.3f) - radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //22
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) + 0.0f) + radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.2f)- radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //23
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.4f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.3f) - radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //24
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.2f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) - 0.1f) - radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);
        //25
        temp = new Vector3f();
        temp.x = (centerPoint.get(0) - 0.6f) - radiusX / 2.0f;
        temp.y = (centerPoint.get(0) +0.1f) + radiusX / 2.0f;
        temp.z = (centerPoint.get(0) - radiusX + 0.5f) ;
        tempVertices.add(temp);


        vertices.clear();

//        //depan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(8));
        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(11));


        //belakang
        vertices.add(tempVertices.get(12));
        vertices.add(tempVertices.get(13));
        vertices.add(tempVertices.get(14));
        vertices.add(tempVertices.get(15));
        vertices.add(tempVertices.get(16));
        vertices.add(tempVertices.get(17));
        vertices.add(tempVertices.get(18));
        vertices.add(tempVertices.get(19));
        vertices.add(tempVertices.get(20));
        vertices.add(tempVertices.get(21));
        vertices.add(tempVertices.get(22));
        vertices.add(tempVertices.get(23));



        //kiri
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(12));
        vertices.add(tempVertices.get(23));
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(22));
        vertices.add(tempVertices.get(23));
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(21));
        vertices.add(tempVertices.get(22));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(9));


        //kanan
        vertices.add(tempVertices.get(15));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(16));
        vertices.add(tempVertices.get(15));
        vertices.add(tempVertices.get(16));
        vertices.add(tempVertices.get(17));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(16));
        vertices.add(tempVertices.get(17));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(18));


        //bawah
        vertices.add(tempVertices.get(19));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(19));
        vertices.add(tempVertices.get(20));
        vertices.add(tempVertices.get(21));
        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(8));
        vertices.add(tempVertices.get(20));
        vertices.add(tempVertices.get(21));

        //atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(23));
        vertices.add(tempVertices.get(12));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(13));
        vertices.add(tempVertices.get(12));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(14));
        vertices.add(tempVertices.get(13));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(15));
        vertices.add(tempVertices.get(14));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));


    }
    public void createTube() {
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
    public void createTubeSleep(){
        vertices.clear();
        float x,y1, y2,z = 0;
        for (double i = 0; i < 360; i += 360 / 360) {
            x = (float) (centerPoint.x + radiusX * Math.cos(i));
            y1 = (centerPoint.y + (radiusY / 2));
            y2 = (centerPoint.y - (radiusY / 2));
            z = (float) (centerPoint.z + radiusZ * Math.sin(i));
            vertices.add(new Vector3f(x,z,y2));
            vertices.add(new Vector3f(x,z,y1));
        }
        for (int i=0; i<360; i+= 360/360){
            vertices.add(vertices.get(i));
            vertices.add(vertices.get(i+360));
        }
    }

    public void createHead() {
        float pi = (float) Math.PI;
        for (float v = -pi / 2; v <= pi / 2; v += pi / 100) {
            for (float u = -pi; u <= pi; u += pi / 100) {

                Float x = radiusX * (float) Math.cos(v) * (float) Math.cos(u);
                Float y = radiusY * (float) Math.cos(v) * (float) Math.sin(u);
                Float z = radiusZ * (float) Math.sin(v);
                vertices.add(new Vector3f(x, y, z));
            }
        }

    }

    public void createHand() {
        float pi = (float) Math.PI;
        for (float v = -pi / 2; v <= pi / 2; v += pi / 100) {
            for (float u = -pi; u <= pi; u += pi / 100) {

                Float x = radiusX * (float) Math.cos(v) * (float) Math.cos(u);
                Float y = radiusY * (float) Math.cos(v) * (float) Math.sin(u);
                Float z = radiusZ * (float) Math.sin(v);
                vertices.add(new Vector3f(x, y, z));
            }
        }

    }
//    public void createNails(){
//        float pi = (float) Math.PI;
//        for (float u = -pi; u <= pi; u += pi / 36) {
//            for (float v = -pi / 2; v <= pi / 2; v += pi / 36) {
//
//                Float x = radiusX * (1 / (float) Math.cos(v)) * (float) Math.cos(u);
//                Float y = radiusY * (1 / (float) Math.cos(v)) * (float) Math.sin(u);
//                Float z = radiusZ * (float) Math.tan(v);
//                vertices.add(new Vector3f(y, z, x));
//            }
//        }

//    }


    public void createSphere() {
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount; i++) {
            StackAngle = pi / 2 - 1 * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; j++) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }


        }

    }

    public double degToRad(float degree) {
        return (degree * Math.PI / (float) 180);
    }

    public void createEllipsoid() {
        float pi = (float) Math.PI;
        for (float v = -pi / 2; v <= pi / 2; v += pi / 100) {
            for (float u = -pi; u <= pi; u += pi / 100) {

                Float x = radiusX * (float) Math.cos(v) * (float) Math.cos(u);
                Float y = radiusY * (float) Math.cos(v) * (float) Math.sin(u);
                Float z = radiusZ * (float) Math.sin(v);
                vertices.add(new Vector3f(x, y, z));
            }
        }
    }

    //hyperboloid 1 side
    public void createHyperboloidEdit() {
        for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
            {
                float x = this.radiusX * (float) ((Math.cosh(u)) * Math.cos(u));
                float y = this.radiusY * (float) ((Math.cosh(u)) * Math.sin(u));
                float z = this.radiusZ * (float) (Math.sinh(u));
                vertices.add(new Vector3f(x, y, z));

            }
        }

    }

    //Eliptic Cone
    public void elipticCone() {
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 100) {
                float x = this.radiusX * (float) ((v) * Math.cos(u));
                float y = this.radiusY * (float) ((v) * Math.sin(u));
                float z = this.radiusZ * (float) (v);
                vertices.add(new Vector3f(x, y, z));

            }
        }
    }

    //Eliptic Paraboloid
    public void elipticParaboloid() {
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 100) {
                float x = this.radiusX * (float) ((v) * Math.cos(u));
                float y = this.radiusY * (float) ((v) * Math.sin(u));
                float z = this.radiusZ * (float) (Math.pow(v, 2));
                vertices.add(new Vector3f(x, y, z));

            }
        }
    }

    public void createHyperboloid1() {
        float pi = (float) Math.PI;
        for (float u = -pi; u <= pi; u += pi / 36) {
            for (float v = -pi / 2; v <= pi / 2; v += pi / 36) {

                Float x = radiusX * (1 / (float) Math.cos(v)) * (float) Math.cos(u);
                Float y = radiusY * (1 / (float) Math.cos(v)) * (float) Math.sin(u);
                Float z = radiusZ * (float) Math.tan(v);
                vertices.add(new Vector3f(y, z, x));
            }
        }

    }

    public void createHyperboloid2sheet1() {
        float pi = (float) Math.PI;
        for (float u = -pi / 2; u <= pi / 2; u += pi / 36) {
            for (float v = -pi / 2; v <= pi / 2; v += pi / 36) {

                Float x = radiusX * (float) Math.tan(v) * (float) Math.cos(u);
                Float y = radiusY * (float) Math.tan(v) * (float) Math.sin(u);
                Float z = radiusZ * (1 / (float) Math.cos(v));
                vertices.add(new Vector3f(x, z, y));
            }
        }

    }

    public void createHyperboloid2sheet2() {
        float pi = (float) Math.PI;
        for (float u = pi / 2; u <= 3 * pi / 2; u += pi / 36) {
            for (float v = -pi / 2; v <= pi / 2; v += pi / 36) {

                Float x = radiusX * (float) Math.tan(v) * (float) Math.cos(u);
                Float y = radiusY * (float) Math.tan(v) * (float) Math.sin(u);
                Float z = radiusZ * (1 / (float) Math.cos(v));
                vertices.add(new Vector3f(x, z, y));
            }
        }
    }


    public void createTriangle() {
        vertices.clear();
        int degree = 90;
        for (float i = 0; i < 3; i++) {
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
            if (degree == 90) {
                degree += 135;
            } else {
                degree += 90;
            }
        }
    }


    public void createBox() {

        Vector3f temp = new Vector3f();

        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();


        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(5));
        //atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));


    }

//    public void draw() {
//        drawSetup();
//        glLineWidth(1);
//        glPointSize(0);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

}
