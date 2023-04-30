package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2d_Gummy extends ShaderProgram {
    List<Vector3f> vertices;

    int vao;
    int vbo;

    UniformsMap uniformsMap;
    Vector4f color;
    public Matrix4f model;

    public List<Object2d_Gummy> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object2d_Gummy> childObject) {
        this.childObject = childObject;
    }

    public List<Float> getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(List<Float> centerPoint) {
        this.centerPoint = centerPoint;
    }

    int vboColor;
    List<Object2d_Gummy> childObject;
    List<Float> centerPoint;
    Matrix4f x;
    List<Vector3f> verticesColor;


    public Object2d_Gummy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("projection");
        uniformsMap.createUniform("view");
        this.color = color;
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
        centerPoint = Arrays.asList(0f, 0f, 0f);

    }

    public void move(double x, double y, int save){
        vertices.set(save,new Vector3f((float)x,(float)y,0.f));
        setupVAOVBO();

    }
    public void moves(float centerx, float centery){
    }
    public Object2d_Gummy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVertices();

    }

    public void setupVAOVBO() {

        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

    }

    public void setupVAOVBOWithVertices() {

        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);

    }

    public Object2d_Gummy(List<ShaderModuleData> shaderModuleDataList) {
        super(shaderModuleDataList);
    }

    public void draw(Camera_Gummy camera, Projection_Gummy projection) {
        drawSetup(camera, projection);
        // draw the vertices
        // optionalee
        glLineWidth(1);
        glPointSize(0);
        // wajib
        //GL_LINE
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLES_FAN
        //GL_POINT
        glDrawArrays(GL_POLYGON, 0, vertices.size());
//        System.out.println(getChildObject().size());
        for (Object2d_Gummy child : childObject) {
            child.draw(camera, projection);

        }
    }
//    public void DrawWithVertices(){
//        drawSetupWithVertices();
//
//        // draw the vertices
//        // optional
//        glLineWidth(1);
//        glPointSize(0);
//        // wajib
//        //GL_LINE
//        //GL_LINE_STRIP
//        //GL_LINE_LOOP
//        //GL_TRIANGLES
//        //GL_TRIANGLES_FAN
//        //GL_POINT
//        glDrawArrays(GL_TRIANGLES,0,vertices.size());
//    }
//    public void drawLine() {
//        drawSetup();
//        // draw the vertices
//        // optional
//        glLineWidth(1);
//        glPointSize(1);
//        // wajib
//        //GL_LINE
//        //GL_LINE_STRIP
//        //GL_LINE_LOOP
//        //GL_TRIANGLES
//        //GL_TRIANGLES_FAN
//        //GL_POINT
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

    public void addVertices(Vector3f newVertices) {
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public Matrix4f getMatrix() {
        return model;
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object2d_Gummy child : childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }

    }

    public void rotateObject(Float degree, Float x, Float y, Float z) {
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        for (Object2d_Gummy child : childObject) {
            child.rotateObject(degree, x, y, z);
        }

    }

    public void scaleObject(Float scaleX, Float scaleY, Float scaleZ) {
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
        for (Object2d_Gummy child : childObject) {
            child.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public float getCenterx() {
        return vertices.get(0).x;

    }

    public float getCentery() {
        return vertices.get(0).y;

    }

    public float getCenterz() {
        return vertices.get(0).z;
    }

    public void drawSetup(Camera_Gummy camera, Projection_Gummy projection) {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());

        //bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);


    }
//    public void drawSetupWithVertices(){
//        bind();
//        //bind VBO
//        glEnableVertexAttribArray(0);
//        glBindBuffer(GL_ARRAY_BUFFER,vbo);
//        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
//
//        //bind VBOColor
//        glEnableVertexAttribArray(1);
//        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
//        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
//    }

}
