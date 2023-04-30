package Engine;

import org.joml.Math;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Tube_Kristofer extends Circle_Kristofer {
    float height1;
    float height2;
    public Tube_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float height1, Float height2) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.height1 = height1;
        this.height2 = height2;
        createTube();
        setupVAOVBO();
    }

    public Tube_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float height1, Float height2, Float mark) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.height1 = height1;
        this.height2 = height2;
        createTubeHalf();
        setupVAOVBO();
    }

    public Tube_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float height1, Float height2, Float mark1, Float mark2) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.height1 = height1;
        this.height2 = height2;
        createTube3per4();
        setupVAOVBO();
    }

    public Float getradiusY(){
        return radiusY;
    }
    public void createTube(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double u = 0; u<= 360; u+=0.05){
            float x = centerPoint.get(0)+ radiusX * (float)(Math.cos(Math.toRadians(u)));
            float y = centerPoint.get(1)+ radiusY * (float)(Math.sin(Math.toRadians(u)));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ -height1/2.0f));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ height2/2.0f));

            vertices = temp;
        }
    }

    public void createTubeHalf(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double u = 0; u<= 180; u+=0.005){
            float x = centerPoint.get(0)+ radiusX * (float)(Math.cos(Math.toRadians(u)));
            float y = centerPoint.get(1)+ radiusY * (float)(Math.sin(Math.toRadians(u)));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ -height1/2.0f));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ height2/2.0f));

            vertices = temp;
        }
    }

    public void createTube3per4(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double u = 0; u<= 210; u+=0.005){
            float x = centerPoint.get(0)+ radiusX * (float)(Math.cos(Math.toRadians(u)));
            float y = centerPoint.get(1)+ radiusY * (float)(Math.sin(Math.toRadians(u)));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ -height1/2.0f));
            temp.add(new Vector3f(x,y, centerPoint.get(2)+ height2/2.0f));
            vertices = temp;
        }
    }

//    public void elipticParaboloid(){
//        for(double v = -Math.PI / 2; v <= Math.PI/2; v+= Math.PI / 36){
//            for(double u = -u = -Math.PI; u <= Math.PI; u += Math.PI / 36){
//                float x = this.radiusX * (float)((v * Math.cos(u)));
//                float y = this.radiusY * (float)((v * Math.sin(u)));
//                float z = this.radiusZ * (float)(Math.pow(v, 2));
//                vertices.add(new Vector3f(x,y,z));
//            }
//        }
//    }
}
