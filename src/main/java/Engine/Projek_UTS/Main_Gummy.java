package Engine.Projek_UTS;

import Engine.*;

import org.joml.Vector4f;
import org.lwjgl.opengl.GL;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;


public class Main_Gummy {

    private Window window = new Window(800, 800, "Hello World");
    private ArrayList<Object2d_Gummy> Objects = new ArrayList<>();

    private ArrayList<Object2d_Gummy> sayap = new ArrayList<>();

    private int SimpanIndex = 0;
    int perputaranSumbuX;
    int perputaranSumbuY;
    int perputaranSumbuZ;
    int titikSumbuZ;
    boolean batasBawah;
    boolean batasAtas;



    private ArrayList<Object2d_Gummy> ObjectsSphere = new ArrayList<>();
    private ArrayList<Object2d_Gummy> background_Gum = new ArrayList<>();
    private ArrayList<Object2d_Gummy> background2 = new ArrayList<>();
    private ArrayList<Object2d_Gummy> ObjectsRectangle = new ArrayList<>();
    private ArrayList<Object2d_Gummy> dragon = new ArrayList<>();
    int count = 0;
    int temp = 0;
    boolean blink = false;

    int tes = 0;


    private MouseInput mouseInput;


    float countDegree = 0.0f;
    Projection_Gummy projection_gummy = new Projection_Gummy(window.getWidth(), window.getHeight());

    Camera_Gummy camera_gummy = new Camera_Gummy();


    public void init_Gummy() {
        window.init();
        GL.createCapabilities();


        camera_gummy.setPosition(0, 0, 2.7f);


        background_Gum.add(new sphere_Gummy(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.6f,1.0f,1.0f,0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f,100,100,8
        ));

        background_Gum.get(0).translateObject(0.5f,0.0f,-2.0f);



        background2.add(new sphere_Gummy(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.950f,0.813f,0.608f,0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f,100,100,8
        ));
        background2.get(0).translateObject(0.5f,0.0f,-2.0f);



        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 0.2f, 0.6f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.5f,
                0.65f,
                0.5f,
                36,
                18, 6

        ));
        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 0.2f, 0.6f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.15f,
                -0.27f,
                0.2f,
                36,
                18, 2

        ));

        dragon.get(1).rotateObject((float) Math.toRadians(45.0f), 0f, 0f, -1.0f);
        dragon.get(1).translateObject(-0.5f, -0.1f, 0.0f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 0.2f, 0.6f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.15f,
                -0.27f,
                0.2f,
                36,
                18, 2

        ));

        dragon.get(2).rotateObject((float) Math.toRadians(45.0f), 0f, 0f, 1.0f);
        dragon.get(2).translateObject(0.5f, -0.1f, 0.0f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 0.2f, 0.6f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                -0.1f,
                0.2f,
                36,
                18, 3

        ));
        dragon.get(3).translateObject(0.0f, -0.1f, -0.85f);


        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.15f,
                -0.04f,
                0.080f,
                36,
                18, 6

        ));
        dragon.get(4).rotateObject((float) Math.toRadians(-20.0f), 0.7f, 0.5f, 0.0f);
        dragon.get(4).translateObject(0.0f, 0f, 0.48f);

        dragon.get(4).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                -0.07f,
                0.080f,
                36,
                18, 7

        ));
        dragon.get(4).getChildObject().get(0).translateObject(0.0f, -0.05f, 0.48f);


//       nailsDragon.add(new sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//
//                new ArrayList<>(),
//                new Vector4f(180.0f, 0.0f, 80.0f, 1.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                0.2f,
//                -0.3f,
//                0.2f,
//                36,
//                18, 3
//
//        ));

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.14f,
                -0.030f,
                0.1f,
                36,
                18, 6

        ));

        dragon.get(5).rotateObject((float) Math.toRadians(10.0f), 0f, 0f, 1.0f);
        dragon.get(5).translateObject(-0.15f, 0.25f, 0.42f);


        dragon.get(5).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.14f,
                -0.030f,
                0.1f,
                36,
                18, 6
        ));
        dragon.get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(10.0f), 0f, 0f, -1.0f);
        dragon.get(5).getChildObject().get(0).translateObject(0.15f, 0.25f, 0.42f);


        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(255.0f, 255.0f, 255.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.08f,
                0.08f,
                0.070f,
                36,
                18, 6

        ));
        dragon.get(6).translateObject(-0.10f, 0.15f, 0.44f);

        dragon.get(6).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(255.0f, 255.0f, 255.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.08f,
                0.08f,
                0.070f,
                36,
                18, 6
        ));
        dragon.get(6).getChildObject().get(0).translateObject(0.10f, 0.15f, 0.44f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 255.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.065f,
                0.07f,
                0.07f,
                36,
                18, 6

        ));
        dragon.get(7).translateObject(-0.10f, 0.15f, 0.45f);

        dragon.get(7).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 255.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.065f,
                0.07f,
                0.07f,
                36,
                18, 6
        ));
        dragon.get(7).getChildObject().get(0).translateObject(0.10f, 0.15f, 0.45f);


        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.050f,
                0.04f,
                0.07f,
                36,
                18, 6

        ));
        dragon.get(8).translateObject(-0.10f, 0.15f, 0.455f);

        dragon.get(8).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.050f,
                0.04f,
                0.07f,
                36,
                18, 6
        ));
        dragon.get(8).getChildObject().get(0).translateObject(0.10f, 0.15f, 0.455f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 3

        ));
        dragon.get(9).rotateObject((float) Math.toRadians(100.0f), 1.0f, 0f, 0f);
        dragon.get(9).translateObject(0.3f, 0.50f, 0.0f);


        dragon.get(9).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 3
        ));
        dragon.get(9).getChildObject().get(0).rotateObject((float) Math.toRadians(100.0f), 1.0f, 0.0f, 0.0f);
        dragon.get(9).getChildObject().get(0).translateObject(-0.3f, 0.50f, 0.0f);


        dragon.get(1).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(70.0f), -0.5f, 0.7f, 0.1f);
        dragon.get(1).getChildObject().get(0).translateObject(-0.75f, -0.35f, -0.1f);


        dragon.get(1).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(100.0f), -0.6f, 0.7f, 0.1f);
        dragon.get(1).getChildObject().get(1).translateObject(-0.77f, -0.35f, 0.05f);

        dragon.get(1).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(150.0f), -0.5f, 0.8f, 0.1f);
        dragon.get(1).getChildObject().get(2).translateObject(-0.65f, -0.30f, 0.25f);


        dragon.get(2).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(70.0f), -0.5f, -0.7f, 0.1f);
        dragon.get(2).getChildObject().get(0).translateObject(0.75f, -0.33f, -0.08f);


        dragon.get(2).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(2).getChildObject().get(1).rotateObject((float) Math.toRadians(70.0f), -0.5f, -0.7f, -0.1f);
        dragon.get(2).getChildObject().get(1).translateObject(0.7f, -0.33f, -0.2f);

        dragon.get(2).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.862f, 0.094f, 0.302f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f,
                36,
                18, 3

        ));
        dragon.get(2).getChildObject().get(2).rotateObject((float) Math.toRadians(120.0f), -0.5f, -0.8f, 0.1f);
        dragon.get(2).getChildObject().get(2).translateObject(0.75f, -0.28f, 0.15f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 7

        ));
        dragon.get(10).scaleObject(0.55f, 0.4f, 0.1f);
        dragon.get(10).translateObject(0.0f, -0.05f, 0.52f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 7

        ));
        dragon.get(10).getChildObject().get(0).scaleObject(0.9f, 0.4f, 0.6f);
        dragon.get(10).getChildObject().get(0).translateObject(0.2f, 0.06f, 0.48f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.937f, 0.129f, 0.533f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 7

        ));
        dragon.get(10).getChildObject().get(1).scaleObject(0.9f, 0.4f, 0.5f);
        dragon.get(10).getChildObject().get(1).translateObject(-0.18f, 0.06f, 0.51f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.819f, 0.105f, 0.105f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 7

        ));
        dragon.get(10).getChildObject().get(2).scaleObject(0.33f, 0.32f, 0.1f);
        dragon.get(10).getChildObject().get(2).translateObject(0.0f, -0.055f, 0.525f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 8

        ));
        dragon.get(10).getChildObject().get(3).scaleObject(0.2f, 0.28f, 0.1f);
        dragon.get(10).getChildObject().get(3).translateObject(-0.015f, -0.028f, 0.535f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 8

        ));
        dragon.get(10).getChildObject().get(4).scaleObject(0.2f, 0.28f, 0.1f);
        dragon.get(10).getChildObject().get(4).translateObject(0.015f, -0.028f, 0.535f);


        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 8

        ));
        dragon.get(10).getChildObject().get(5).scaleObject(0.2f, 0.18f, 0.1f);
        dragon.get(10).getChildObject().get(5).translateObject(0.015f, -0.08f, 0.535f);

        dragon.get(10).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 8

        ));
        dragon.get(10).getChildObject().get(6).scaleObject(0.2f, 0.18f, 0.1f);
        dragon.get(10).getChildObject().get(6).translateObject(-0.015f, -0.08f, 0.535f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 9

        ));
        dragon.get(11).scaleObject(0.8f, 0.8f, 0.1f);
        dragon.get(11).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 0.8f, 0.0f);
        dragon.get(11).translateObject(-0.2f, 0.2f, -0.6f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 9

        ));
        dragon.get(12).scaleObject(0.8f, 0.8f, 0.1f);
        dragon.get(12).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 0.8f, 0.0f);
        dragon.get(12).translateObject(0.2f, 0.2f, -0.6f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 10

        ));
        dragon.get(13).scaleObject(0.4f, 0.2f, 0.2f);
        dragon.get(13).translateObject(0.05f, 0f, 0.53f);

        dragon.get(13).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 10

        ));
        dragon.get(13).getChildObject().get(0).scaleObject(0.4f, 0.2f, 0.2f);
        dragon.get(13).getChildObject().get(0).translateObject(-0.05f, 0f, 0.53f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(14).scaleObject(1.4f, 1.8f, 1.8f);
        dragon.get(14).translateObject(0.2f, -0.4f, 0f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(15).scaleObject(1.4f, 1.8f, 1.8f);
        dragon.get(15).translateObject(-0.2f, -0.4f, 0f);


        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(16).scaleObject(0.8f, 0.8f, 0.7f);
        dragon.get(16).translateObject(-0.4f, 0f, 0f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(17).scaleObject(0.8f, 0.8f, 0.7f);
        dragon.get(17).translateObject(0.4f, 0f, 0f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(18).scaleObject(0.8f, 0.8f, 0.7f);
        dragon.get(18).translateObject(0.15f, 0.15f, -0.3f);

        dragon.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 1

        ));
        dragon.get(19).scaleObject(0.8f, 0.8f, 0.7f);
        dragon.get(19).translateObject(-0.15f, 0.15f, -0.3f);


        //tooth


        sayap.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(0.886f, 0.122f, 0.2f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 9

        ));


//        animasi menjadi besar
//        dragon.add(new sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//
//                new ArrayList<>(),
//                new Vector4f(180.0f, 0.0f, 80.0f, 1.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                0.55f,
//                0.95f,
//                0.5f,
//                36,
//                18, 7
//
//        ));
//


        ObjectsRectangle.add(new Rectangle_Gummy(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)),

                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.4f, 0.3f, 0.0f),
                                        new Vector3f(-0.6f, 0.0f, 0.0f),
                                        new Vector3f(-0.2f, 0.0f, 0.0f),
                                        new Vector3f(0.0f, 0.5f, 0.0f)
                                )

                        ),
                        new Vector4f(1.0f, 0.6f, .0f, 1.0f),
                        Arrays.asList(0, 1, 2)
                )
        );

        ObjectsSphere.add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(255.0f, 255.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18, 2

        ));
        ObjectsSphere.get(0).translateObject(0.1f, 0.0f, 0.0f);

        //childObject
        ObjectsSphere.get(0).getChildObject().add(new sphere_Gummy(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),

                new ArrayList<>(),
                new Vector4f(255.0f, 255.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18, 0

        ));


        ObjectsSphere.get(0).getChildObject().get(0).translateObject(0.75f, 0.25f, 0.25f);
        ObjectsSphere.get(0).getChildObject().get(0).setCenterPoint(Arrays.asList(0.25f, 0.0f, 0.0f));
    }
    public void input_Gummy() {


        if (window.isKeyPressed(GLFW_KEY_Z)) {
            float x1 = dragon.get(7).getMatrix().get(3, 0);
            float x2 = dragon.get(7).getMatrix().get(3, 1);
            float x3 = dragon.get(7).getMatrix().get(3, 2);
            dragon.get(7).translateObject(-x1, -x2, -x3);
            dragon.get(7).scaleObject(0.991f, 0.991f, 0.991f);
            dragon.get(7).translateObject(x1, x2, x3);
            dragon.get(8).translateObject(-x1, -x2, -x3);
            dragon.get(8).scaleObject(0.991f, 0.991f, 0.991f);
            dragon.get(8).translateObject(-x1, -x2, -x3);

        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            if (temp == 0) {

                float x1 = dragon.get(19).getMatrix().get(3, 0);
                float x2 = dragon.get(19).getMatrix().get(3, 1);
                float x3 = dragon.get(19).getMatrix().get(3, 2);
                dragon.get(11).translateObject(-x1, -x2, -x3);
                dragon.get(11).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0f, 0f);
                dragon.get(11).translateObject(x1, x2, x3);

                float x4 = dragon.get(19).getMatrix().get(3, 0);
                float x5 = dragon.get(19).getMatrix().get(3, 1);
                float x6 = dragon.get(19).getMatrix().get(3, 2);
                dragon.get(12).translateObject(-x4, -x5, -x6);
                dragon.get(12).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0f, 0f);
                dragon.get(12).translateObject(x4, x5, x6);

                count++;
                if (count == 80) {
                    temp = 1;
                }

            }
        }
        if (temp == 1) {
            float x1 = dragon.get(19).getMatrix().get(3, 0);
            float x2 = dragon.get(19).getMatrix().get(3, 1);
            float x3 = dragon.get(19).getMatrix().get(3, 2);
            dragon.get(11).translateObject(-x1, -x2, -x3);
            dragon.get(11).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0f, 0f);
            dragon.get(11).translateObject(x1, x2, x3);

            float x4 = dragon.get(19).getMatrix().get(3, 0);
            float x5 = dragon.get(19).getMatrix().get(3, 1);
            float x6 = dragon.get(19).getMatrix().get(3, 2);
            dragon.get(12).translateObject(-x4, -x5, -x6);
            dragon.get(12).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0f, 0f);
            dragon.get(12).translateObject(x4, x5, x6);

            count--;
            if (count == 0) {
                temp = 0;
            }


        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (int i = 0; i < dragon.size(); i++) {
                dragon.get(i).translateObject(0.0f, 0.0f, -0.01f);

            }
            if (titikSumbuZ > 359) {
                titikSumbuZ = 0;

            } else if (titikSumbuZ < 0) {
                titikSumbuZ = 359;

            }

            if (titikSumbuZ == 5) {
                batasBawah = true;
                batasAtas = false;

            }

            if (titikSumbuZ == 330) {
                batasAtas = true;
                batasBawah = false;
            }
            float pos1 = dragon.get(16).getMatrix().get(3, 0);
            float pos2 = dragon.get(16).getMatrix().get(3, 1);
            float pos3 = dragon.get(16).getMatrix().get(3, 2);

            float pos4 = dragon.get(17).getMatrix().get(3, 0);
            float pos5 = dragon.get(17).getMatrix().get(3, 1);
            float pos6 = dragon.get(17).getMatrix().get(3, 2);


            int rotate1 = 360 - perputaranSumbuZ;
            int rotate2 = 360 - perputaranSumbuY;
            int rotate3 = 360 - perputaranSumbuX;

            for (int i = 0; i < rotate1; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (int i = 0; i < dragon.size(); i++) {
                dragon.get(i).translateObject(-0.01f, 0.0f, 0.0f);

            }
            if (titikSumbuZ > 359) {
                titikSumbuZ = 0;

            } else if (titikSumbuZ < 0) {
                titikSumbuZ = 359;

            }

            if (titikSumbuZ == 5) {
                batasBawah = true;
                batasAtas = false;

            }

            if (titikSumbuZ == 330) {
                batasAtas = true;
                batasBawah = false;
            }
            float pos1 = dragon.get(16).getMatrix().get(3, 0);
            float pos2 = dragon.get(16).getMatrix().get(3, 1);
            float pos3 = dragon.get(16).getMatrix().get(3, 2);

            float pos4 = dragon.get(17).getMatrix().get(3, 0);
            float pos5 = dragon.get(17).getMatrix().get(3, 1);
            float pos6 = dragon.get(17).getMatrix().get(3, 2);


            int rotate1 = 360 - perputaranSumbuZ;
            int rotate2 = 360 - perputaranSumbuY;
            int rotate3 = 360 - perputaranSumbuX;

            for (int i = 0; i < rotate1; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (int i = 0; i < dragon.size(); i++) {
                dragon.get(i).translateObject(0f, 0f, 0.01f);

            }
            if (titikSumbuZ > 359) {
                titikSumbuZ = 0;

            } else if (titikSumbuZ < 0) {
                titikSumbuZ = 359;

            }

            if (titikSumbuZ == 5) {
                batasBawah = true;
                batasAtas = false;

            }

            if (titikSumbuZ == 330) {
                batasAtas = true;
                batasBawah = false;
            }
            float pos1 = dragon.get(16).getMatrix().get(3, 0);
            float pos2 = dragon.get(16).getMatrix().get(3, 1);
            float pos3 = dragon.get(16).getMatrix().get(3, 2);

            float pos4 = dragon.get(17).getMatrix().get(3, 0);
            float pos5 = dragon.get(17).getMatrix().get(3, 1);
            float pos6 = dragon.get(17).getMatrix().get(3, 2);


            int rotate1 = 360 - perputaranSumbuZ;
            int rotate2 = 360 - perputaranSumbuY;
            int rotate3 = 360 - perputaranSumbuX;

            for (int i = 0; i < rotate1; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (int i = 0; i < dragon.size(); i++) {
                dragon.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }

            if (titikSumbuZ > 359) {
                titikSumbuZ = 0;

            } else if (titikSumbuZ < 0) {
                titikSumbuZ = 359;

            }

            if (titikSumbuZ == 5) {
                batasBawah = true;
                batasAtas = false;

            }

            if (titikSumbuZ == 330) {
                batasAtas = true;
                batasBawah = false;
            }
            float pos1 = dragon.get(16).getMatrix().get(3, 0);
            float pos2 = dragon.get(16).getMatrix().get(3, 1);
            float pos3 = dragon.get(16).getMatrix().get(3, 2);

            float pos4 = dragon.get(17).getMatrix().get(3, 0);
            float pos5 = dragon.get(17).getMatrix().get(3, 1);
            float pos6 = dragon.get(17).getMatrix().get(3, 2);


            int rotate1 = 360 - perputaranSumbuZ;
            int rotate2 = 360 - perputaranSumbuY;
            int rotate3 = 360 - perputaranSumbuX;

            for (int i = 0; i < rotate1; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }
        if (window.isKeyPressed(GLFW_KEY_E)) {


            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);

            }
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {


            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);

            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {

            for (int i = 0; i < dragon.size(); i++) {
                dragon.get(i).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 1.0f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            if (!blink) {
                for (int j = 0; j < 80; j++) {
                    for (int i = 0; i < dragon.size(); i++) {
                        dragon.get(i).scaleObject(0.991f, 0.991f, 0.991f);
                    }
                }
            }
            blink = true;


        }
        if (window.isKeyPressed(GLFW_KEY_T)) {
            if (blink) {
                for (int j = 0; j < 80; j++) {
                    for (int i = 0; i < dragon.size(); i++) {
                        dragon.get(i).scaleObject(1.01f, 1.01f, 1.01f);
                    }
                }
            }
            blink = false;
        }


        if (window.isKeyPressed(GLFW_KEY_F)) {

            if (titikSumbuZ > 359) {
                titikSumbuZ = 0;

            } else if (titikSumbuZ < 0) {
                titikSumbuZ = 359;

            }

            if (titikSumbuZ == 5) {
                batasBawah = true;
                batasAtas = false;

            }

            if (titikSumbuZ == 330) {
                batasAtas = true;
                batasBawah = false;
            }
            float pos1 = dragon.get(16).getMatrix().get(3, 0);
            float pos2 = dragon.get(16).getMatrix().get(3, 1);
            float pos3 = dragon.get(16).getMatrix().get(3, 2);

            float pos4 = dragon.get(17).getMatrix().get(3, 0);
            float pos5 = dragon.get(17).getMatrix().get(3, 1);
            float pos6 = dragon.get(17).getMatrix().get(3, 2);


            int rotate1 = 360 - perputaranSumbuZ;
            int rotate2 = 360 - perputaranSumbuY;
            int rotate3 = 360 - perputaranSumbuX;

            for (int i = 0; i < rotate1; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }


//            horn.get(0).rotateObject((float) Math.toRadians(1.0f), -0.5f, 0.5f, 0.0f);

//            matahari.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            merkurius.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            venus.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bumi.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            mars.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bulan.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            System.out.println("W");

//        if (window.isKeyPressed(GLFW_KEY_G)) {
//            ObjectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            matahari.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            merkurius.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            venus.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bumi.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            mars.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bulan.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            System.out.println("W");
        //bumi
//            float x1Bumi = bumi.get(0).getMatrix().get(3, 0);
//            float x2Bumi = bumi.get(0).getMatrix().get(3, 1);
//            float x3Bumi = bumi.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Bumi);
//            System.out.println(x2Bumi);
//            System.out.println(x3Bumi);
//            bumi.get(0).translateObject(-x1Bumi, -x2Bumi, -x3Bumi);
//            bumi.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bumi.get(0).translateObject(x1Bumi, x2Bumi, x3Bumi);
//            //Matahari
//            float x1Mat = matahari.get(0).getMatrix().get(3, 0);
//            float x2Mat = matahari.get(0).getMatrix().get(3, 1);
//            float x3Mat = matahari.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Mat);
//            System.out.println(x2Mat);
//            System.out.println(x3Mat);
//            matahari.get(0).translateObject(-x1Mat, -x2Mat, -x3Mat);
//            matahari.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            matahari.get(0).translateObject(x1Mat, x2Mat, x3Mat);
//            //merkurius
//            float x1Merk = merkurius.get(0).getMatrix().get(3, 0);
//            float x2Merk = merkurius.get(0).getMatrix().get(3, 1);
//            float x3Merk = merkurius.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Merk);
//            System.out.println(x2Merk);
//            System.out.println(x3Merk);
//            merkurius.get(0).translateObject(-x1Merk, -x2Merk, -x3Merk);
//            merkurius.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            merkurius.get(0).translateObject(x1Merk, x2Merk, x3Merk);
//            //venus
//            float x1Venus = venus.get(0).getMatrix().get(3, 0);
//            float x2Venus = venus.get(0).getMatrix().get(3, 1);
//            float x3Venus = venus.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Venus);
//            System.out.println(x2Venus);
//            System.out.println(x3Venus);
//            venus.get(0).translateObject(-x1Venus, -x2Venus, -x3Venus);
//            venus.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            venus.get(0).translateObject(x1Venus, x2Venus, x3Venus);
//            //mars
//            float x1Mars = mars.get(0).getMatrix().get(3, 0);
//            float x2Mars = mars.get(0).getMatrix().get(3, 1);
//            float x3Mars = mars.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Mars);
//            System.out.println(x2Mars);
//            System.out.println(x3Mars);
//            mars.get(0).translateObject(-x1Mars, -x2Mars, -x3Mars);
//            mars.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            mars.get(0).translateObject(x1Mars, x2Mars, x3Mars);
//            //bulan
//            float x1Bulan = bulan.get(0).getMatrix().get(3, 0);
//            float x2Bulan = bulan.get(0).getMatrix().get(3, 1);
//            float x3Bulan = bulan.get(0).getMatrix().get(3, 2);
//            System.out.println(x1Bulan);
//            System.out.println(x2Bulan);
//            System.out.println(x3Bulan);
//            bulan.get(0).translateObject(-x1Bulan, -x2Bulan, -x3Bulan);
//            bulan.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bulan.get(0).translateObject(x1Bulan, x2Bulan, x3Bulan);
//
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_H)) {
//            float x1PutarPorosBumi = bumi.get(0).getMatrix().get(3, 0);
//            float x2PutarPorosBumi = bumi.get(0).getMatrix().get(3, 1);
//            float x3PutarPorosBumi = bumi.get(0).getMatrix().get(3, 2);
//            bulan.get(0).translateObject(-x1PutarPorosBumi, -x2PutarPorosBumi, -x3PutarPorosBumi);
//            bulan.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            bulan.get(0).translateObject(x1PutarPorosBumi, x2PutarPorosBumi, x3PutarPorosBumi);
//        }

    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
            GL.createCapabilities();
            input_Gummy();

//            for (Object2d object2d : Objects) {
//                object2d.DrawWithVertices();
//            }
//            for (Object2d object2d : ObjectsSphere) {
////                System.out.println(object2d.getChildObject().size());
//                object2d.draw();
//            }
            for (Object2d_Gummy object2d : background_Gum) {
                object2d.draw(camera_gummy, projection_gummy);
            }
            for (Object2d_Gummy object2d : background2) {
                object2d.draw(camera_gummy, projection_gummy);
            }

            for (Object2d_Gummy object2d : dragon) {
                object2d.draw(camera_gummy, projection_gummy);
            }

//            for (Object2d object2d : sayap) {
//                object2d.draw(camera, projection);
//            }


//            for (Object2d object2d : merkurius) {
//                object2d.draw();
//            }
//            for (Object2d object2d : venus) {
//                object2d.draw();
//            }
//            for (Object2d object2d : mars) {
//                object2d.draw();
//            }
//            for (Object2d object2d : bumi) {
//                object2d.draw();
//            }
//            for (Object2d object2d : bulan) {
//                object2d.draw();
//            }

//            for (Object2d object2d : ObjectsRectangle) {
//                object2d.draw();
//            }
//            for (Object2d object2d : grass) {
//                object2d.draw();
//            }
//            for (Object2d object2d : rooftop) {
//                object2d.draw();
//            }
//            for (Object2d object2d : body) {
//                object2d.draw();
//            }
//            for (Object2d object2d : door) {
//                object2d.draw();
//            }
//            for (Object2d object2d : Moon) {
//                object2d.draw();
//            }
//            for (Object2d object2d : Moon2) {
//                object2d.draw();
//            }
//            for (Object2d object2d : objectPointControl) {
//                object2d.drawLine();
//            }
//            for (Object2d object2d : square) {
//                object2d.draw();
//            }

            //code

            //restore state
            glDisableVertexAttribArray(0);

            //poll for window events.
            //the key callback above will only be
            //invoked during this call.
            glfwPollEvents();

        }
    }


    public void run() {
        init_Gummy();
        loop();

        // terminate GLFW and
        // free the error callback

        glfwTerminate();
        glfwSetErrorCallback(null).free();

        //tes

    }



    public static void main(String[] args) {
        System.out.println("hello world");
        new Main_Gummy().run();

    }
}

