package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object2d extends ShaderProgram{

    List<Vector3f> vertices;
    List<Vector3f> curve;
    List<Vector3f> verticesColor;
    List<Integer> pascal;
    int vao;
    int vbo;
    int vboCurve;
    int vboColor;
    Vector4f color;
    UniformsMap uniformsmap;

    public Object2d(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.curve = new ArrayList<>(List.of());
        this.pascal = new ArrayList<>(List.of());
        setupVAOVBO();
        this.color = color;
        uniformsmap = new UniformsMap(getProgramId());
        uniformsmap.createUniform("uni_color");
    }

    public Object2d(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
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

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        //set vbo color
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }

    public void setupVAOVBOCurve(){
        //set vbo
        vboCurve = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboCurve);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(curve),
                GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        uniformsmap.setUniform("uni_color", color);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void drawSetupCurve(){
        bind();
        uniformsmap.setUniform("uni_color", color);
        // Bind VBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboCurve);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void drawSetupWithVerticesColor(){
        bind();
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_TRIANGLES,0,
                vertices.size());
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_TRIANGLES,0,
                vertices.size());
    }

    public void drawLine(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        glDrawArrays(GL_LINE_STRIP,0,
                vertices.size());
    }

    public void drawCurve(){
        drawSetupCurve();
        // Draw the vertices
        //optional
        glLineWidth(10);
        glPointSize(10);
        //wajib
        glDrawArrays(GL_LINE_STRIP,0,
                curve.size());
    }

    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        createCurve();
        setupVAOVBO();
    }

    public Vector3f getVertice(){
        return vertices.get(0);
    }

    public void moveSquare(Vector3f newPosition){
        vertices.clear();
        this.vertices.add(new Vector3f(newPosition.x, newPosition.y, 0));
        float x, y, z = 0;
        int angle = 45;
        for (double i=angle; i < 360+angle; i+=360/4){
            x = (float)(newPosition.x + 0.05*Math.cos(Math.toRadians(i)));
            y = (float)(newPosition.y + 0.05*Math.sin(Math.toRadians(i)));
            this.vertices.add(new Vector3f(x, y,z));
        }
        setupVAOVBO();
    }

    public void moveLine(int index, Vector3f newPosition){
        this.vertices.set(index, newPosition);
        createCurve();
        setupVAOVBO();
    }
}