package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class RectangleCircle extends Object2d{

    List<Integer> index;
    //index buffer object || element buffer object
    int ibo;

    public RectangleCircle(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint,
                List<Integer> index, float rX, float rY, double angle) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        this.vertices.add(new Vector3f(centerPoint.x, centerPoint.y, 0));
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index),
                GL_STATIC_DRAW);
        float x, y, z = 0;
        angle = angle + 45;
        for (double i=angle; i < 360+angle; i+=360/4){
            x = (float)(centerPoint.x + rX*Math.cos(Math.toRadians(i)));
            y = (float)(centerPoint.y + rY*Math.sin(Math.toRadians(i)));
            this.vertices.add(new Vector3f(x, y,z));
        }
        setupVAOVBO();
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //optional
        glPointSize(10);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 1);
    }
}
