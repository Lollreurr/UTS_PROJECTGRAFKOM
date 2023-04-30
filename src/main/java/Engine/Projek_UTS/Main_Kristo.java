package Engine.Projek_UTS;//kristofer steven_C14210139
//Grafkom B

import Engine.*;
import Engine.Object_Kristofer;
import org.joml.Math;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main_Kristo {
    private Window window =
            new Window
    (800,800,"Hello World");
    private ArrayList<Object_Kristofer> object_bg
            = new ArrayList<>();

    private ArrayList<Object_Kristofer> objectsMakiDragon_Kristofer
            = new ArrayList<>();

    public ArrayList<Object_Kristofer> anchorpoint_Kristofer = new ArrayList<>();
    ArrayList<Object_Kristofer> obj_temp_Kristofer = new ArrayList<>();;
    Boolean done_scale_Kristofer = false;

    int degreeX_Kristofer =0;
    int degreeY_Kristofer = 0;
    int degreeZ_Kristofer = 0;
    float tempY_Kristofer = 0;

    float batas_atas_Kristofer = 0.45f;
    float batas_bawah_Kristofer = 0.0f;
    float batas_kiri_Kristofer = -0.45f;
    float batas_kanan_Kristofer = 0.45f;
    float batas_depan_Kristofer = 0.45f;
    float batas_belakang_Kristofer = -0.45f;

    float tempx_Kristofer;
    float tempy_Kristofer;
    float tempz_Kristofer;
    float temp_x_Kristofer = 0.0f;
    float temp_y_Kristofer = 0.0f;
    float temp_z_Kristofer = 0.0f;


    int rotasisayap_Kristofer = 45;
    int curdegree_Kristofer = 45;

    int batas_atasrotasi_Kristofer = 0;
    int batas_bawahrotasi_Kristofer = 0;

    boolean sayapatas_Kristofer = false;
    boolean sayapbawah_Kristofer = true;

    boolean terbang_Kristofer = false;

    int counter_kanan_Kristofer = 0;
    int counter_kiri_Kristofer = 0;

    boolean kaki_kiri_Kristofer = true;
    boolean kaki_kiri_atas_Kristofer = true;
    boolean kaki_kanan_Kristofer = false;
    boolean kaki_kanan_atas_Kristofer = true;

    float camX = 0.0f;
    float camY = 0.0f;
    float camZ = 1.0f;

    float degreecamX = 0.0f;
    float degreecamY = 0.0f;


//    private MouseInput_Kristofer mouseInput_Kristofer;
    Camera_Kristofer camera_Kristofer = new Camera_Kristofer();
    Projection_Kristofer projection_Kristofer = new Projection_Kristofer(window.getWidth(), window.getHeight());
    public void init_Kris(){
        window.init();
        glEnable(GL_DEPTH_TEST);
        GL.createCapabilities();
//        mouseInput_Kristofer = window.getMouseInput();
        camera_Kristofer.setPosition(0.0f,0.0f,1.0f);
        camera_Kristofer.setRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(0.0f));
        //code

        //BACKGROUND
        object_bg.add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0900f,0.924f,1.00f,1.0f),
                Arrays.asList(0.0f,-0.5f,-10.0f),
                50f,
                50f,
                1f,
                36,18
        ));
        object_bg.add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.950f,0.813f,0.608f,1.0f),
                Arrays.asList(0.0f,-0.5f,-1.0f),
                50f,
                1f,
                50f,
                36,18
        ));
//        object_bg.add(new Sphere_Kristofer(
//                Arrays.asList(
//                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.480f,0.466f,0.466f,1.0f),
//                Arrays.asList(0.0f,-0.5f,-1.0f),
//                50f,
//                1f,
//                50f,
//                36,18
//        ));

        object_bg.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f,0.466f,0.466f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                1.5f,
                0f
                ));
        object_bg.get(2).scaleObject(0.3f,0.3f,0.3f);
        object_bg.get(2).rotateObject(Math.toRadians(90),1.0f, 0.0f, 0.0f);
        object_bg.get(2).translateObject(0.3f, -0.05f, -0.2f);
        object_bg.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f,0.466f,0.466f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                1.5f,
                0f
        ));
        object_bg.get(3).scaleObject(0.3f,0.3f,0.3f);
        object_bg.get(3).rotateObject(Math.toRadians(90),1.0f, 0.0f, 0.0f);
        object_bg.get(3).translateObject(-0.5f, -0.05f, -0.7f);

        object_bg.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f,0.466f,0.466f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                1.5f,
                0f
        ));
        object_bg.get(4).scaleObject(0.3f,0.3f,0.3f);
        object_bg.get(4).rotateObject(Math.toRadians(90),1.0f, 0.0f, 0.0f);
        object_bg.get(4).translateObject(-0.35f, -0.05f, -1.0f);

        objectsMakiDragon_Kristofer.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.5f,
                0.4f,
                0.5f
        ));
        objectsMakiDragon_Kristofer.get(0).scaleObject(0.2f,0.2f,0.2f);
        //bagian depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.13f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).scaleObject(0.15f,0.15f,0.15f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.04f);
        //bagian belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.01f,
                0.2f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(1).scaleObject(0.15f,0.15f,0.15f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(1).translateObject(0.0f,0.0f,-0.042f);

        //mata
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.08f,0.08f,0.08f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.05f);

        //pupil atas
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.0204f,0.0630f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.05f,0.05f,0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(20),0.0f,0.0f,1f);
        //pupil bawah
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.0204f,0.0630f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.05f,0.05f,0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f,0.0f,0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(Math.toRadians(130),0.0f,0.0f,1f);
        //titik putih
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.4f,
                0.0f,
                0.09f

        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.025f,0.025f,0.025f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.02f,0.0f,0.054f);

        //Mulut
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f,0.0204f,0.0630f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.04f,0.04f,0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f,0.055f,0.05f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(Math.toRadians(180),0.0f,0.0f,1f);
        //gigi kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.01f,0.01f,0.01f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.01f,0.055f,0.053f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject(Math.toRadians(180),0.0f,0.0f,1f);
        //gigi kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.01f,0.01f,0.01f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.01f,0.055f,0.053f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).rotateObject(Math.toRadians(180),0.0f,0.0f,1f);

        //lidah
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).scaleObject(0.014f,0.014f,0.014f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(0.00f,-0.076f,0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject(Math.toRadians(0),0.0f,0.0f,1f);

        //tanduk kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.985f,0.120f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).scaleObject(0.02f,0.02f,0.02f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(50), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).translateObject(0.0f,0.16f,0.0f);

        //tanduk kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.985f,0.120f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).scaleObject(0.02f,0.02f,0.02f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(-230), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).translateObject(0.155f,0.03f,0.0f);

        //kaki kanan depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).scaleObject(0.015f,0.015f,0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(250), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-0.04f,-0.137f,0.03f);

        //kaki kanan belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).scaleObject(0.015f,0.015f,0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(250), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-0.04f,-0.137f,-0.02f);

        //kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).scaleObject(0.015f,0.015f,0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(295), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-0.15f,-0.06f,0.03f);

        //kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).scaleObject(0.015f,0.015f,0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(0.0f,0.1f,-0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(295), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-0.15f,-0.06f,-0.02f);

        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).scaleObject(0.03f,0.06f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(255), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-0.11f, 0.05f,0.0f);

        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).scaleObject(0.03f,0.06f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).rotateObject(Math.toRadians(120), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).translateObject(-0.15f, 0.05f,0.0f);
        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().add(new plane_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f)
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(1).addVertices(new Vector3f(-0.05f, 0.05f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(1).addVertices(new Vector3f(-0.15f, 0.08f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(1).addVertices(new Vector3f(-0.18f, 0.06f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(1).addVertices(new Vector3f(-0.14f, 0.02f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(1).translateObject(0.0f, -0.02f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(45), 1.0f, 0.0f, 0.0f);
        //sayap kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).scaleObject(0.03f,0.06f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(255), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-0.11f, 0.05f,0.0f);
        //sayap kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.55f,
                0.55f,
                0.5f,36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).scaleObject(0.03f,0.06f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).rotateObject(Math.toRadians(120), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).translateObject(-0.15f, 0.05f,0.0f);
        //sayap kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().add(new plane_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f,0.228f,0.299f,1.0f)
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(1).addVertices(new Vector3f(-0.05f, 0.05f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(1).addVertices(new Vector3f(-0.15f, 0.08f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(1).addVertices(new Vector3f(-0.18f, 0.06f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(1).addVertices(new Vector3f(-0.14f, 0.02f, 0.0f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(1).translateObject(0.0f, -0.02f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(180), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(225), 1.0f, 0.0f, 0.0f);

        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).translateObject(-0.05f, 0.02f,0.0f);

        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).translateObject(0.05f, 0.02f,0.0f);

        //poros kaki kanan depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).translateObject(0.05f, -0.07f,0.02f);
        //poros kaki kanan belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).translateObject(0.05f, -0.07f,-0.02f);
        //poros kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).translateObject(-0.05f, -0.07f,0.02f);
        //poros kaki kiri belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));
        //
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).translateObject(-0.05f, -0.07f,-0.02f);

        //poros mata
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).translateObject(0.0f, 0.0f,0.049f);

        //poros alis
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),new ArrayList<>(),
                new Vector4f(0.00820f,0.410f,0.142f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.05f,
                0.05f,
                0.05f,36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).scaleObject(0.03f,0.03f,0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).translateObject(0.0f, 0.055f,0.049f);

        //alis
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Curve_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f,0f,0f,1.0f)
                ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.04f, 0.04f, 0.052f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 0.07f, 0.052f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.04f, 0.04f, 0.052f));


        //        objectsDragon.add(new Curve(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.760f,0.228f,0.299f,1.0f)
//        ));
//        objectsDragon.get(0).addVertices(new Vector3f(0.05f, 0.05f, 0.02f));
//        objectsDragon.get(0).addVertices(new Vector3f(0.15f, 0.08f, 0.02f));
//        objectsDragon.get(0).addVertices(new Vector3f(0.13f, 0.02f, 0.02f));
//        objectsDragon.get(0).addVertices(new Vector3f(0.05f, 0.05f, 0.02f));

    }

    public void batas_sayap_Kristofer(){
        batas_atasrotasi_Kristofer = rotasisayap_Kristofer + 15;
        batas_bawahrotasi_Kristofer = rotasisayap_Kristofer - 15;
    }
    public void input_Kris(){
        if(window.isKeyPressed(GLFW_KEY_W)){
            camZ+= 0.1f;
            camera_Kristofer.moveForward ((float) Math.toRadians(0.1f));
//            camera_Kristofer.addRotation((float)Math.toRadians(0f), (float)Math.toRadians(2f));
//            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
//
//            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
//                obj.rotateObject((float) Math.toRadians(1), 1f, 0f,0f);
//            }
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
//            degreeY_Kristofer -= Math.toRadians(1);
//            if(degreeY_Kristofer < 0){
//                degreeY_Kristofer = 359;
//            }
//            batas_sayap_Kristofer();
        }
        if(window.isKeyPressed(GLFW_KEY_A)){
            camY -= 0.1f;
            camera_Kristofer.moveLeft((float) Math.toRadians(0.1f));
//            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
//            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
//                obj.rotateObject((float) Math.toRadians(1f), 0f, 1f,0f);
//            }
//            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
//            degreeX_Kristofer -= Math.toRadians(1);
//            if(degreeX_Kristofer < 0){
//                degreeX_Kristofer = 359;
//            }
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
            camZ-= 0.1f;
            camera_Kristofer.moveBackwards ((float) Math.toRadians(0.1f));
//            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
//
//            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
//                obj.rotateObject((float) Math.toRadians(1f), -1f, 0f,0f);
//            }
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
//            degreeY_Kristofer += Math.toRadians(1);
//            if (degreeY_Kristofer > 359){
//                degreeY_Kristofer = 0;
//            }
//            batas_sayap_Kristofer();
        }
        if(window.isKeyPressed(GLFW_KEY_D)){
            camY += 0.1f;
            camera_Kristofer.moveRight((float) Math.toRadians(0.1f));
//            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
//
//            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
//
//            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
//                obj.rotateObject((float) Math.toRadians(1f), 0f, -1f,0f);;
//            }
//            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
//            degreeX_Kristofer += Math.toRadians(1);
//            if(degreeX_Kristofer > 359){
//                degreeX_Kristofer = 0;
//            }
        }
        if(window.isKeyPressed(GLFW_KEY_Q)){
            camX -= 0.1f;
            camera_Kristofer.moveUp((float) Math.toRadians(0.1f));
        }
        if(window.isKeyPressed(GLFW_KEY_E)){
            camX += 0.1f;
            camera_Kristofer.moveDown((float) Math.toRadians(0.1f));
        }
        if(window.isKeyPressed(GLFW_KEY_R)){
            degreecamX += 0.1f;
            camera_Kristofer.addRotation((float)Math.toRadians(0.1f), (float)Math.toRadians(0.0f));
        }
        if(window.isKeyPressed(GLFW_KEY_T)){
            degreecamX -= 0.1f;
            camera_Kristofer.addRotation((float)Math.toRadians(-0.1f), (float)Math.toRadians(0.0f));
        }
        if(window.isKeyPressed(GLFW_KEY_Y)){
            degreecamY += 0.1f;
            camera_Kristofer.addRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(0.1f));
        }
        if(window.isKeyPressed(GLFW_KEY_U)){
            degreecamY -= 0.1f;
            camera_Kristofer.addRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(-0.1f));
        }
        if(window.isKeyPressed(GLFW_KEY_Z)){
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);

            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
                obj.rotateObject((float) Math.toRadians(1), 1f, 0f,0f);
            }

            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
            degreeY_Kristofer -= Math.toRadians(1);
            if(degreeY_Kristofer < 0){
                degreeY_Kristofer = 359;
            }
            batas_sayap_Kristofer();
        }
        if(window.isKeyPressed(GLFW_KEY_X)){
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);

            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
                obj.rotateObject((float) Math.toRadians(1f), 0f, -1f,0f);;
            }
            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
            degreeX_Kristofer += Math.toRadians(1);
            if(degreeX_Kristofer > 359){
                degreeX_Kristofer = 0;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_C)){
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);

            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
                obj.rotateObject((float) Math.toRadians(1f), -1f, 0f,0f);
            }

            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
            degreeY_Kristofer += Math.toRadians(1);
            if (degreeY_Kristofer > 359){
                degreeY_Kristofer = 0;
            }
            batas_sayap_Kristofer();
        }
        if(window.isKeyPressed(GLFW_KEY_V)){
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
                obj.rotateObject((float) Math.toRadians(1f), 0f, 1f,0f);
            }
            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
            degreeX_Kristofer -= Math.toRadians(1);
            if(degreeX_Kristofer < 0){
                degreeX_Kristofer = 359;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_F)){
            if(temp_z_Kristofer < batas_depan_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, 0.01f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(0.0f, 0.0f, 0.01f);
                }
                temp_z_Kristofer +=0.01f;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_G)){
            if(temp_z_Kristofer > batas_belakang_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, -0.01f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(0.0f, 0.0f, -0.01f);
                }
                temp_z_Kristofer -=0.01f;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            if(temp_x_Kristofer > batas_kiri_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(-0.01f, 0.0f, 0.0f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(-0.01f, 0.0f, 0.0f);
                }
                temp_x_Kristofer -= 0.01f;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_J)){
            if(temp_x_Kristofer < batas_kanan_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(+0.01f, 0.0f, 0.0f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(0.01f, 0.0f, 0.0f);
                }
                temp_x_Kristofer += 0.01f;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_K)) {
            if (temp_y_Kristofer > batas_bawah_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, -0.01f, 0.0f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(0.0f, -0.01f, 0.0f);
                }
                tempY_Kristofer -= 0.01f;
                temp_y_Kristofer -= 0.01f;
            }
        }
        if(window.isKeyPressed(GLFW_KEY_L)){
            if(temp_y_Kristofer < batas_atas_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.01f, 0.0f);
                }
                for(Object_Kristofer obj : anchorpoint_Kristofer){
                    obj.translateObject(0.0f, 0.01f, 0.0f);
                }
                tempY_Kristofer += 0.01f;
                temp_y_Kristofer += 0.01f;
            }

        }
        if(window.isKeyPressed(GLFW_KEY_M)){
            if(temp_x_Kristofer > batas_kiri_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(-0.01f, 0.0f, 0.0f);
                }
                temp_x_Kristofer -= 0.01f;
            }
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
                obj.rotateObject((float) Math.toRadians(1f), 0f, -1f,0f);;
            }
            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
            degreeX_Kristofer += Math.toRadians(1f);
        }

        if(window.isKeyPressed(GLFW_KEY_1)){
            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).model.transformPosition(new Vector3f());
            //mata
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).model.transformPosition(new Vector3f());
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).model.transformPosition(new Vector3f());
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).model.transformPosition(new Vector3f());

            if(obj_temp_Kristofer.size() < 20 && !done_scale_Kristofer) {
                obj_temp_Kristofer.add(objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0));

                tempx_Kristofer = degreeX_Kristofer;
                tempy_Kristofer = degreeY_Kristofer;
                tempz_Kristofer = degreeZ_Kristofer;

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                while (tempx_Kristofer > 0){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                    tempx_Kristofer--;
                }

                while (tempy_Kristofer > 0){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    tempy_Kristofer--;
                }

                while (tempz_Kristofer > 0){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                    tempz_Kristofer--;
                }

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, -poros1.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, -poros2.z);
                //scaling
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 0.9f, 1.0f);

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, poros1.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, poros2.z);


                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, -poros1.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, -poros2.z);
                //translate
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, -0.001f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).translateObject(0.0f, -0.001f, 0.0f);

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, poros1.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, poros2.z);


                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                while (tempx_Kristofer < degreeX_Kristofer){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                    tempx_Kristofer++;
                }

                while (tempy_Kristofer < degreeY_Kristofer){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                    tempy_Kristofer++;
                }

                while (tempz_Kristofer < degreeZ_Kristofer){
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

                    tempz_Kristofer++;
                }

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            }
            else if(obj_temp_Kristofer.size() == 20 && !done_scale_Kristofer) {
                done_scale_Kristofer = true;
                obj_temp_Kristofer.add(objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0));
            }
            else{
                if(obj_temp_Kristofer.size() == 0) {
                    done_scale_Kristofer = false;
                    tempx_Kristofer = degreeX_Kristofer;
                    tempy_Kristofer = degreeY_Kristofer;
                    tempz_Kristofer = degreeZ_Kristofer;

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                    while (tempx_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        tempx_Kristofer--;
                    }

                    while (tempy_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        tempy_Kristofer--;
                    }

                    while (tempz_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                        tempz_Kristofer--;
                    }

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, -poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, -poros2.z);
                    //scaling
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 1.1f, 1.0f);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, poros2.z);


                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, -poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, -poros2.z);
                    //translate
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, -0.001f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).translateObject(0.0f, -0.001f, 0.0f);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, poros2.z);


                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                    while (tempx_Kristofer < degreeX_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                        tempx_Kristofer++;
                    }

                    while (tempy_Kristofer < degreeY_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                        tempy_Kristofer++;
                    }

                    while (tempz_Kristofer < degreeZ_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

                        tempz_Kristofer++;
                    }

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

                }
                else{
                    obj_temp_Kristofer.remove(obj_temp_Kristofer.size()-1);
                    tempx_Kristofer = degreeX_Kristofer;
                    tempy_Kristofer = degreeY_Kristofer;
                    tempz_Kristofer = degreeZ_Kristofer;

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                    while (tempx_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        tempx_Kristofer--;
                    }

                    while (tempy_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        tempy_Kristofer--;
                    }

                    while (tempz_Kristofer > 0){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                        tempz_Kristofer--;
                    }

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, -poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, -poros2.z);
                    //scaling
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 1.1f, 1.0f);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, poros2.z);


                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poros1.x, poros1.y, -poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poros2.x, poros2.y, -poros2.z);
                    //translate
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, 0.001f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).translateObject(0.0f, 0.001f, 0.0f);

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poros1.x, -poros1.y, poros1.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poros2.x, -poros2.y, poros2.z);


                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(poscenter.x, poscenter.y, poscenter.z);

                    while (tempx_Kristofer < degreeX_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                        tempx_Kristofer++;
                    }

                    while (tempy_Kristofer < degreeY_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                        tempy_Kristofer++;
                    }

                    while (tempz_Kristofer < degreeZ_Kristofer){
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

                        tempz_Kristofer++;
                    }

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

                }
            }
            //            tempX1 = degreeX;
//            tempY1 = degreeY;
//            tempZ1 = degreeZ;
//            if(obj_temp.size() < 20 && !done_scale) {
//                obj_temp.add(objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0));
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//                while(tempX1 < 0){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                    tempX1--;
//                }
//                while(tempY1 < 0){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                    tempY1--;
//                }
//                while(tempZ1 < 0){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                    tempZ1--;
//                }
//                objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
//
//                //scaling & translate
//                objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 0.9f, 1.0f);
//                objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, -0.001f, 0.0f);
//
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//
//                while (tempX1 <= degreeX){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 1f, 0f, 0f);
//                    tempX1++;
//                }
//                while (tempY1 <= degreeY){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 1f, 0f);
//                    tempY1++;
//                }
//                while (tempZ1 <= degreeZ){
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, 1f);
//                    tempZ1++;
//                }
//
//                objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
////                if()
////                objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
////                objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//            }
//            else if(obj_temp.size() == 20 && !done_scale){
//                done_scale = true;
//                obj_temp.add(objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0));
//            }
//            else{
//                if(obj_temp.size() == 0){
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//                    while(tempX1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                        tempX1--;
//                    }
//                    while(tempY1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                        tempY1--;
//                    }
//                    while(tempZ1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                        tempZ1--;
//                    }
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
//
//                    //scaling & translate
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 1.1f, 1.0f);
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, 0.001f, 0.0f);
//
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//
//                    while (tempX1 <= degreeX){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 1f, 0f, 0f);
//                        tempX1++;
//                    }
//                    while (tempY1 <= degreeY){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 1f, 0f);
//                        tempY1++;
//                    }
//                    while (tempZ1 <= degreeZ){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, 1f);
//                        tempZ1++;
//                    }
//
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
//                    done_scale = false;
//                }
//                else{
//                    obj_temp.remove(obj_temp.size()-1);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//                    while(tempX1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), -1f, 0f, 0f);
//                        tempX1--;
//                    }
//                    while(tempY1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, -1f, 0f);
//                        tempY1--;
//                    }
//                    while(tempZ1 < 0){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(Math.toRadians(1f), 0f, 0f, -1f);
//                        tempZ1--;
//                    }
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
//
//                    //scaling & translate
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 1.1f, 1.0f);
//                    objectsDragon.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, 0.001f, 0.0f);
//
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(-pos2.x, -pos2.y, -pos2.z);
//
//                    while (tempX1 <= degreeX){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 1f, 0f, 0f);
//                        tempX1++;
//                    }
//                    while (tempY1 <= degreeY){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 1f, 0f);
//                        tempY1++;
//                    }
//                    while (tempZ1 <= degreeZ){
//                        objectsDragon.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(1f), 0f, 0f, 1f);
//                        tempZ1++;
//                    }
//
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(poscenter.x, poscenter.y, poscenter.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, pos1.z);
//                    objectsDragon.get(0).getChildObject().get(0).translateObject(pos2.x, pos2.y, pos2.z);
//                }
//            }
        }
        if(window.isKeyPressed(GLFW_KEY_2)) {
            if(curdegree_Kristofer < 0){
                curdegree_Kristofer = 359;
            }
            else if(curdegree_Kristofer > 359){
                curdegree_Kristofer = 0;
            }

            if(curdegree_Kristofer > 70){
                sayapatas_Kristofer = true;
                sayapbawah_Kristofer = false;
            }
            else if(curdegree_Kristofer < 45){
                sayapatas_Kristofer = false;
                sayapbawah_Kristofer = true;
            }

            System.out.println("batas atas : " + batas_atasrotasi_Kristofer);
            System.out.println("batas atas : " + batas_bawahrotasi_Kristofer);

//            List<Float> temp1 = objectsDragon.get(0).getChildObject().get(8).getCenterPoint();
//            List<Float> temp2 = objectsDragon.get(0).getChildObject().get(9).getCenterPoint();
            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).model.transformPosition(new Vector3f());
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).model.transformPosition(new Vector3f());
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).model.transformPosition(new Vector3f());

            tempx_Kristofer = degreeX_Kristofer;
            tempy_Kristofer = degreeY_Kristofer;
            tempz_Kristofer = degreeZ_Kristofer;
//            int rotate1 = 360 - degreeZ;
//            int rotate2 = 360 - degreeY;
//            int rotate3 = 360 - degreeX;


            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            while (tempx_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                tempz_Kristofer--;
            }

//            for (int i=0; i<rotate1; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
//            }
//            for (int i=0; i<rotate2; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
//            }
//            for (int i=0; i<rotate3; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
//            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poscenter.x, poscenter.y, poscenter.z);


            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poros1.x, -poros1.y, poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poros2.x, -poros2.y, poros2.z);

            if(!sayapatas_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                curdegree_Kristofer += 1;
                System.out.println("atas");
//                objectsDragon.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(pos1.x,pos1.y,pos1.z));
//                objectsDragon.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(pos2.x,pos2.y,pos2.z));
            }
            if(!sayapbawah_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                curdegree_Kristofer -= 1;
                System.out.println("bawah");
//                objectsDragon.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(pos1.x,pos1.y,pos1.z));
//                objectsDragon.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(pos2.x,pos2.y,pos2.z));
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poros1.x, poros1.y, -poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poros2.x, poros2.y, -poros2.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poscenter.x,poscenter.y,poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poscenter.x,poscenter.y,poscenter.z);
            while (tempx_Kristofer < degreeX_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                tempz_Kristofer++;
            }
//            for(int i = 0; i < degreeX; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);
//            }
//            for(int i = 0; i < degreeY; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
//            }
//            for(int i = 0; i < degreeZ; i++){
//                objectsDragon.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
//                objectsDragon.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
//            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
        }
        if(window.isKeyPressed(GLFW_KEY_3)){
            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
            //poros kaki kanan depan
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).model.transformPosition(new Vector3f());
            //poros kaki kanan belakang
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).model.transformPosition(new Vector3f());
            //poros kaki kiri depan
            Vector3f poros3 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).model.transformPosition(new Vector3f());
            //poros kaki kiri belakang
            Vector3f poros4 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).model.transformPosition(new Vector3f());

            tempx_Kristofer = degreeX_Kristofer;
            tempy_Kristofer = degreeY_Kristofer;
            tempz_Kristofer = degreeZ_Kristofer;

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            while (tempx_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                tempz_Kristofer--;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poscenter.x, poscenter.y, poscenter.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poros1.x, -poros1.y, poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poros2.x, -poros2.y, poros2.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poros3.x, -poros3.y, poros3.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poros4.x, -poros4.y, poros4.z);

            if(kaki_kiri_Kristofer){
                if(counter_kiri_Kristofer < 15 && kaki_kiri_atas_Kristofer){
                    counter_kiri_Kristofer +=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                }
                else if(counter_kiri_Kristofer == 15 && kaki_kiri_atas_Kristofer){
                    kaki_kiri_atas_Kristofer = false;
                }
                else if(counter_kiri_Kristofer == 0 && !kaki_kiri_atas_Kristofer){
                    kaki_kiri_atas_Kristofer = true;
                    kaki_kiri_Kristofer = false;
                    kaki_kanan_Kristofer = true;
                }
                else{
                    counter_kiri_Kristofer -=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
            }
            else if(kaki_kanan_Kristofer){
                if(counter_kanan_Kristofer < 15 && kaki_kanan_atas_Kristofer){
                    counter_kanan_Kristofer +=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
                else if(counter_kanan_Kristofer == 15 && kaki_kanan_atas_Kristofer){
                    kaki_kanan_atas_Kristofer = false;
                }
                else if(counter_kanan_Kristofer == 0 && !kaki_kanan_atas_Kristofer){
                    kaki_kanan_atas_Kristofer = true;
                    kaki_kanan_Kristofer = false;
                    kaki_kiri_Kristofer = true;
                }
                else{
                    counter_kanan_Kristofer -=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                }
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poros1.x, poros1.y, -poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poros2.x, poros2.y, -poros2.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poros3.x, poros3.y, -poros3.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poros4.x, poros4.y, -poros4.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poscenter.x, poscenter.y, poscenter.z);

            while (tempx_Kristofer < degreeX_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                tempz_Kristofer++;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
        }
    }

    public void fly_MakiDragon_Kristofer(){
        if(terbang_Kristofer) {
            if (curdegree_Kristofer < 0) {
                curdegree_Kristofer = 359;
            } else if (curdegree_Kristofer > 359) {
                curdegree_Kristofer = 0;
            }

            if (curdegree_Kristofer > 70) {
                sayapatas_Kristofer = true;
                sayapbawah_Kristofer = false;
            } else if (curdegree_Kristofer < 45) {
                sayapatas_Kristofer = false;
                sayapbawah_Kristofer = true;
            }

            System.out.println("batas atas : " + batas_atasrotasi_Kristofer);
            System.out.println("batas atas : " + batas_bawahrotasi_Kristofer);

            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).model.transformPosition(new Vector3f());
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).model.transformPosition(new Vector3f());
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).model.transformPosition(new Vector3f());

            tempx_Kristofer = degreeX_Kristofer;
            tempy_Kristofer = degreeY_Kristofer;
            tempz_Kristofer = degreeZ_Kristofer;

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            while (tempx_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                tempz_Kristofer--;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poscenter.x, poscenter.y, poscenter.z);


            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poros1.x, -poros1.y, poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poros2.x, -poros2.y, poros2.z);

            if (!sayapatas_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                curdegree_Kristofer += 1;
                System.out.println("atas");
            }
            if (!sayapbawah_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                curdegree_Kristofer -= 1;
                System.out.println("bawah");
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poros1.x, poros1.y, -poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poros2.x, poros2.y, -poros2.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(poscenter.x, poscenter.y, poscenter.z);
            while (tempx_Kristofer < degreeX_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                tempz_Kristofer++;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
        }
        else{
            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
            //poros kaki kanan depan
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).model.transformPosition(new Vector3f());
            //poros kaki kanan belakang
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).model.transformPosition(new Vector3f());
            //poros kaki kiri depan
            Vector3f poros3 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).model.transformPosition(new Vector3f());
            //poros kaki kiri belakang
            Vector3f poros4 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).model.transformPosition(new Vector3f());

            tempx_Kristofer = degreeX_Kristofer;
            tempy_Kristofer = degreeY_Kristofer;
            tempz_Kristofer = degreeZ_Kristofer;

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            while (tempx_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                tempz_Kristofer--;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poscenter.x, poscenter.y, poscenter.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poros1.x, -poros1.y, poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poros2.x, -poros2.y, poros2.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poros3.x, -poros3.y, poros3.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poros4.x, -poros4.y, poros4.z);

            if(kaki_kiri_Kristofer){
                if(counter_kiri_Kristofer < 15 && kaki_kiri_atas_Kristofer){
                    counter_kiri_Kristofer +=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                }
                else if(counter_kiri_Kristofer == 15 && kaki_kiri_atas_Kristofer){
                    kaki_kiri_atas_Kristofer = false;
                }
                else if(counter_kiri_Kristofer == 0 && !kaki_kiri_atas_Kristofer){
                    kaki_kiri_atas_Kristofer = true;
                    kaki_kiri_Kristofer = false;
                    kaki_kanan_Kristofer = true;
                }
                else{
                    counter_kiri_Kristofer -=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
            }
            else if(kaki_kanan_Kristofer){
                if(counter_kanan_Kristofer < 15 && kaki_kanan_atas_Kristofer){
                    counter_kanan_Kristofer +=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
                else if(counter_kanan_Kristofer == 15 && kaki_kanan_atas_Kristofer){
                    kaki_kanan_atas_Kristofer = false;
                }
                else if(counter_kanan_Kristofer == 0 && !kaki_kanan_atas_Kristofer){
                    kaki_kanan_atas_Kristofer = true;
                    kaki_kanan_Kristofer = false;
                    kaki_kiri_Kristofer = true;
                }
                else{
                    counter_kanan_Kristofer -=1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                }
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poros1.x, poros1.y, -poros1.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poros2.x, poros2.y, -poros2.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poros3.x, poros3.y, -poros3.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poros4.x, poros4.y, -poros4.z);

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(poscenter.x, poscenter.y, poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(poscenter.x, poscenter.y, poscenter.z);

            while (tempx_Kristofer < degreeX_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer){
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                tempz_Kristofer++;
            }

            objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
            objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
        }
    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    1.0f, 1.0f,
                    0.0f);
            GL.createCapabilities();
            input_Kris();

            //code
            for(Object_Kristofer object: anchorpoint_Kristofer){
                object.draw(camera_Kristofer, projection_Kristofer);
            }
            for(Object_Kristofer object: object_bg){
                object.draw(camera_Kristofer, projection_Kristofer);
            }
            for (Object_Kristofer object: objectsMakiDragon_Kristofer){
                object.draw(camera_Kristofer, projection_Kristofer);
            }

            if(tempY_Kristofer > 0.0f){
                terbang_Kristofer = true;
            }

            if(tempY_Kristofer <= 0.0f){
                terbang_Kristofer = false;
            }

            fly_MakiDragon_Kristofer();

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init_Kris();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main_Kristo().run();
    }
}