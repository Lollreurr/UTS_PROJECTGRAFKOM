package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Line extends Object_IceCubeD {

    public Line(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public void draw(){
//        drawSetup();
        glLineWidth(2); //ketebalan garis
        glPointSize(2); //besar kecil vertex
        glDrawArrays(GL_LINE_LOOP,
                0,
                vertices.size());
    }
}
