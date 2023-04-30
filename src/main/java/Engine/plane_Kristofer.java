package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class plane_Kristofer extends Object_Kristofer {
    List<Vector3f> curve;
    List<Integer> pascal;
    int vboCurve;
    public plane_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
        this.curve = new ArrayList<>(List.of());
        this.pascal = new ArrayList<>(List.of());
    }
    public void createPascal(){
        pascal.clear();
        int value;
        int baseFac = 1;
        for (int i=1; i<vertices.size(); i++){
            baseFac = baseFac * i;
        }

        pascal.add(1);

        for (int i=1; i<vertices.size(); i++){
            if (i == vertices.size() - 1){
                pascal.add(1);
                break;
            }

            int secFac = 1;
            for (int j = i; j>0; j--) {
                secFac = secFac * j;
            }

            int thirdFac = 1;
            for (int j = vertices.size()-1 - i; j>0; j--){
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
        float x,y, count;

        for (double i=0; i<1; i+=0.01) {
            x = 0;
            y = 0;
            for (double j = 0; j < vertices.size(); j++) {
                //P(t) = (1-t)^5 v1 + 5 (1-t)^4 t v2 + 10 (1-t)^3 t^2 v3 + 10 (1-t)^2 t^3 v4 + 5 (1-t) t^4 v5 + t^5 v6
                count = (float) pascal.get((int)j) * (float) Math.pow((1-i), vertices.size()-1 - j) * (float) Math.pow(i, j);

                x += vertices.get((int)j).x * count;
                y += vertices.get((int)j).y * count;
            }
            curve.add(new Vector3f(x, y, 0));
            System.out.println(x + " " + y);
        }

        setupVAOVBOCurve();
    }
    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        createCurve();
        setupVAOVBO();
    }
    public void setupVAOVBOCurve(){
        //set vbo
        vboCurve = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboCurve);
        glBufferData(GL_ARRAY_BUFFER,
                Utils_Kristofer.listoFloat(curve),
                GL_STATIC_DRAW);
    }
    public void drawSetupCurve(Camera_Kristofer camera, Projection_Kristofer projection){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());
        // Bind VBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboCurve);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }
    public void drawCurve(Camera_Kristofer camera, Projection_Kristofer projection){
        drawSetupCurve(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(10);
        glPointSize(10);
        //wajib
        glDrawArrays(GL_LINE_STRIP,0,
                curve.size());
    }

    public void drawLine(Camera_Kristofer camera, Projection_Kristofer projection){
        drawSetup(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_POLYGON,0,
                vertices.size());
    }

    public void drawLineCurve(Camera_Kristofer camera, Projection_Kristofer projection){
        drawSetup(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_LINE_STRIP,0,
                vertices.size());
    }

    @Override
    public void draw(Camera_Kristofer camera, Projection_Kristofer projection) {
        drawLine(camera, projection);
//        drawCurve(camera, projection);
    }

}
