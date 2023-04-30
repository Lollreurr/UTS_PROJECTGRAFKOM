package Engine.Projek_UTS;

import Engine.*;
import org.joml.Math;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main_All {
    private Window window =
            new Window
                    (1000, 800, "Hello World");
    private ArrayList<Object_IceCubeD> objectIceCubeDS
            = new ArrayList<>();
    private ArrayList<Object_IceCubeD> background
            = new ArrayList<>();
    private ArrayList<Object_IceCubeD> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object_IceCubeD> objectIceCubeDPointsControl
            = new ArrayList<>();
    int degX, degY, degZ, tempX, tempY, tempZ, rotZ;
    int tempDot;
    boolean rotMax, rotMin;

    Camera_IceCubeD cameraIceCubeD = new Camera_IceCubeD();
    Projection_IceCubeD projectionIceCubeD = new Projection_IceCubeD(window.getWidth(), window.getHeight());

    private ArrayList<ObjectBlockDragon> blockDragon
            = new ArrayList<>();

    private ArrayList<ObjectBlockDragon> anchorPoint
            = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    // block dragon position
    int blockX = 0;
    int blockY = 0;
    int blockZ = 0;

    // block dragon rotation
    int blockDegreeX = 0;
    int blockDegreeY = 0;
    int blockDegreeZ = 0;

    // block dragon hands variable
    int blockHandZ = 0;
    boolean blockHandMin = false;
    boolean blockHandMax = false;
    boolean blockHandToggle = false;

    // block dragon wings variable
    int blockWingY = 0;
    boolean blockWingMin = false;
    boolean blockWingMax = false;

    // block dragon flying variable
    int blockHeight = 0;

    // block dragon sit animation variable
    boolean blockSit = false;

    // block dragon scaling
    boolean big = true;
    int bigCount = 0;


    private ArrayList<Object_Kristofer> object_bg
            = new ArrayList<>();

    private ArrayList<Object_Kristofer> objectsMakiDragon_Kristofer
            = new ArrayList<>();

    public ArrayList<Object_Kristofer> anchorpoint_Kristofer = new ArrayList<>();
    ArrayList<Object_Kristofer> obj_temp_Kristofer = new ArrayList<>();
    ;
    Boolean done_scale_Kristofer = false;

    int degreeX_Kristofer = 0;
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

    public void init_all() {
        window.init();
        glEnable(GL_DEPTH_TEST);
        GL.createCapabilities();

        //ALL BACKGROUND
        object_bg.add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.960f, 0.00f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                50f,
                1f,
                50f,
                36, 18
        ));
        object_bg.get(0).translateObject(0.5f, -1f, 0.0f);
        object_bg.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.15f
        ));
        object_bg.get(1).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).translateObject(-0.7f, -0.05f, 0.2f);
        object_bg.get(1).scaleObject(1.0f, 1.5f, 1.0f);
        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.15f
        ));
        object_bg.get(1).getChildObject().get(0).scaleObject(0.9f, 0.9f, 0.9f);
        object_bg.get(1).getChildObject().get(0).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(0).translateObject(-0.7f, -0.049f, 0.2f);
        object_bg.get(1).getChildObject().get(0).scaleObject(1.0f, 1.5f, 1.0f);
        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.3f
        ));
        object_bg.get(1).getChildObject().get(1).scaleObject(0.7f, 0.7f, 0.9f);
        object_bg.get(1).getChildObject().get(1).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(1).translateObject(-0.7f, 0.05f, 0.2f);
        object_bg.get(1).getChildObject().get(1).scaleObject(1.0f, 1.2f, 1.0f);
        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.3f
        ));
        object_bg.get(1).getChildObject().get(2).scaleObject(0.5f, 0.5f, 0.7f);
        object_bg.get(1).getChildObject().get(2).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(2).translateObject(-0.7f, 0.051f, 0.2f);
        object_bg.get(1).getChildObject().get(2).scaleObject(1.0f, 1.2f, 1.0f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(3).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(3).scaleObject(0.5f, 1.2f, 0.5f);
        object_bg.get(1).getChildObject().get(3).translateObject(-0.5f, -0.065f, 0.2f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(4).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(4).scaleObject(0.4f, 1.2f, 0.4f);
        object_bg.get(1).getChildObject().get(4).translateObject(-0.5f, -0.064f, 0.2f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(5).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(5).scaleObject(0.5f, 1.7f, 0.5f);
        object_bg.get(1).getChildObject().get(5).translateObject(-0.9f, -0.025f, 0.2f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(6).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(6).scaleObject(0.4f, 1.7f, 0.4f);
        object_bg.get(1).getChildObject().get(6).translateObject(-0.9f, -0.024f, 0.2f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(7).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(7).scaleObject(0.5f, 0.6f, 0.5f);
        object_bg.get(1).getChildObject().get(7).translateObject(-0.7f, -0.13f, 0.4f);

        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.2f
        ));
        object_bg.get(1).getChildObject().get(8).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(1).getChildObject().get(8).scaleObject(0.4f, 0.6f, 0.4f);
        object_bg.get(1).getChildObject().get(8).translateObject(-0.7f, -0.129f, 0.4f);

        object_bg.get(1).scaleObject(1.0f, 1.5f, 1.0f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(9).translateObject(-1.36f, 0.2f, 1.45f);
        object_bg.get(1).getChildObject().get(9).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(10).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(10).rotateObject(Math.toRadians(-280), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(10).translateObject(-0.61f, 0.1f, 0.22f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(11).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(11).rotateObject(Math.toRadians(160), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(11).translateObject(-0.66f, 0.1f, 0.12f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(12).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(12).rotateObject(Math.toRadians(60), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(12).translateObject(-0.76f, 0.1f, 0.14f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(13).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(13).rotateObject(Math.toRadians(300), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(13).translateObject(-0.78f, 0.1f, 0.24f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(14).translateObject(-1.35f, -0.2f, 1.67f);
        object_bg.get(1).getChildObject().get(14).scaleObject(0.5f, 0.5f, 0.2f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(15).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(15).rotateObject(Math.toRadians(-280), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(15).translateObject(-0.57f, -0.1f, 0.22f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(16).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(16).rotateObject(Math.toRadians(160), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(16).translateObject(-0.62f, -0.1f, 0.08f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(17).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(17).rotateObject(Math.toRadians(60), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(17).translateObject(-0.8f, -0.1f, 0.1f);

        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.850f, 0.677f, 0.332f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.13f,
                0.05f,
                0.1f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(18).scaleObject(0.5f, 0.5f, 0.2f);
        object_bg.get(1).getChildObject().get(18).rotateObject(Math.toRadians(300), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(18).translateObject(-0.83f, -0.1f, 0.25f);
        //pintu
        object_bg.get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 00.0f),
                0.15f,
                0.15f,
                0.0f,
                0.15f,
                1f
        ));
        object_bg.get(1).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.640f, 0.510f, 0.250f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.3f,
                0.2f,
                0.07f,
                36, 18
        ));
        object_bg.get(1).getChildObject().get(20).translateObject(0.0f, -0.09f, 0.05f);
        object_bg.get(1).getChildObject().get(19).scaleObject(0.3f, 0.3f, 0.3f);
        object_bg.get(1).getChildObject().get(20).scaleObject(0.3f, 0.3f, 0.3f);
        object_bg.get(1).getChildObject().get(19).rotateObject(Math.toRadians(80), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(20).rotateObject(Math.toRadians(80), 0.0f, 1.0f, 0.0f);
        object_bg.get(1).getChildObject().get(19).translateObject(-0.43f, -0.22f, 0.2f);
        object_bg.get(1).getChildObject().get(20).translateObject(-0.434f, -0.22f, 0.2f);

        //gunung
        object_bg.add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.525f, 0.525f, 0.525f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18
        ));
        object_bg.get(2).scaleObject(0.7f, 0.7f, 0.9f);
        object_bg.get(2).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);

        object_bg.get(2).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.525f, 0.525f, 0.525f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18
        ));
        object_bg.get(2).getChildObject().get(0).scaleObject(0.7f, 0.7f, 0.5f);
        object_bg.get(2).getChildObject().get(0).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(2).getChildObject().get(0).translateObject(0.1f, -0.1f, 0.2f);

        object_bg.get(2).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.525f, 0.525f, 0.525f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18
        ));
        object_bg.get(2).getChildObject().get(1).scaleObject(0.7f, 0.7f, 0.3f);
        object_bg.get(2).getChildObject().get(1).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(2).getChildObject().get(1).translateObject(-0.1f, -0.2f, 0.2f);

        object_bg.get(2).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.525f, 0.525f, 0.525f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18
        ));
        object_bg.get(2).getChildObject().get(2).scaleObject(0.7f, 0.7f, 0.7f);
        object_bg.get(2).getChildObject().get(2).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(2).getChildObject().get(2).translateObject(0.3f, -0.05f, 0.2f);

        object_bg.get(2).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.525f, 0.525f, 0.525f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18
        ));
        object_bg.get(2).getChildObject().get(3).scaleObject(1.5f, 1.5f, 0.2f);
        object_bg.get(2).getChildObject().get(3).rotateObject(Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        object_bg.get(2).getChildObject().get(3).translateObject(0.4f, -0.2f, 0.2f);

        object_bg.get(2).translateObject(0.0f, 0.0f, -0.9f);
        object_bg.get(2).scaleObject(12f, 15f, 8f);
        object_bg.get(2).translateObject(-1.5f, 2.85f, -2f);

        object_bg.get(1).translateObject(1.0f, 0.0f, -0.25f);
        object_bg.get(1).scaleObject(2f, 2f, 2f);

        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(0).translateObject(0.5f, 0.6f, -0.7f);
        background.get(0).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(1).translateObject(0.35f, 0.6f, -0.7f);
        background.get(1).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(2).translateObject(0.45f, 0.7f, -0.7f);
        background.get(2).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(3).translateObject(0.0f, 0.8f, -0.7f);
        background.get(3).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(4).translateObject(0.1f, 0.9f, -0.7f);
        background.get(4).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(5).translateObject(-0.4f, 0.7f, -0.7f);
        background.get(5).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(6).translateObject(-0.5f, 0.65f, -0.7f);
        background.get(6).scaleObject(10f, 5f, 10f);
        background.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, -0.5f, 0.0f), 10.0f, 10.0f, 10.0f, 36, 18, 0
        ));
        background.get(7).translateObject(-0.3f, 0.65f, -0.7f);
        background.get(7).scaleObject(10f, 5f, 10f);


        //Gumball dragon
        camera_gummy.setPosition(-2.5f, 0, 6.0f);
//        background_Gum.add(new sphere_Gummy(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.6f,1.0f,1.0f,0.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f,100,100,8
//        ));
//
//        background_Gum.get(0).translateObject(0.5f,0.0f,-2.0f);
//
//
//
//        background2.add(new sphere_Gummy(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.950f,0.813f,0.608f,0.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f,100,100,8
//        ));
//        background2.get(0).translateObject(0.5f,0.0f,-2.0f);


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

        dragon.get(1).rotateObject((float) java.lang.Math.toRadians(45.0f), 0f, 0f, -1.0f);
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

        dragon.get(2).rotateObject((float) java.lang.Math.toRadians(45.0f), 0f, 0f, 1.0f);
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
        dragon.get(4).rotateObject((float) java.lang.Math.toRadians(-20.0f), 0.7f, 0.5f, 0.0f);
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

        dragon.get(5).rotateObject((float) java.lang.Math.toRadians(10.0f), 0f, 0f, 1.0f);
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
        dragon.get(5).getChildObject().get(0).rotateObject((float) java.lang.Math.toRadians(10.0f), 0f, 0f, -1.0f);
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
        dragon.get(9).rotateObject((float) java.lang.Math.toRadians(100.0f), 1.0f, 0f, 0f);
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
        dragon.get(9).getChildObject().get(0).rotateObject((float) java.lang.Math.toRadians(100.0f), 1.0f, 0.0f, 0.0f);
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
        dragon.get(1).getChildObject().get(0).rotateObject((float) java.lang.Math.toRadians(70.0f), -0.5f, 0.7f, 0.1f);
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
        dragon.get(1).getChildObject().get(1).rotateObject((float) java.lang.Math.toRadians(100.0f), -0.6f, 0.7f, 0.1f);
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
        dragon.get(1).getChildObject().get(2).rotateObject((float) java.lang.Math.toRadians(150.0f), -0.5f, 0.8f, 0.1f);
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
        dragon.get(2).getChildObject().get(0).rotateObject((float) java.lang.Math.toRadians(70.0f), -0.5f, -0.7f, 0.1f);
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
        dragon.get(2).getChildObject().get(1).rotateObject((float) java.lang.Math.toRadians(70.0f), -0.5f, -0.7f, -0.1f);
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
        dragon.get(2).getChildObject().get(2).rotateObject((float) java.lang.Math.toRadians(120.0f), -0.5f, -0.8f, 0.1f);
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
        dragon.get(11).rotateObject((float) java.lang.Math.toRadians(-90.0f), 0.0f, 0.8f, 0.0f);
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
        dragon.get(12).rotateObject((float) java.lang.Math.toRadians(-90.0f), 0.0f, 0.8f, 0.0f);
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

        //Gumball scale
        for (Object2d_Gummy sayapp : sayap) {
            sayapp.scaleObject(0.25f, 0.25f, 0.25f);
            sayapp.translateObject(-2.05f, -0.05f, 4.45f);
        }
        for (Object2d_Gummy dragonn : dragon) {
            dragonn.scaleObject(0.25f, 0.25f, 0.25f);
            dragonn.translateObject(-2.05f, -0.05f, 4.45f);
        }
        for (Object2d_Gummy objectsRectanglee : ObjectsRectangle) {
            objectsRectanglee.scaleObject(0.25f, 0.25f, 0.25f);
            objectsRectanglee.translateObject(-2.05f, -0.05f, 4.45f);
        }
        for (Object2d_Gummy objectsSpheree : ObjectsSphere) {
            objectsSpheree.scaleObject(0.25f, 0.25f, 0.25f);
            objectsSpheree.translateObject(-2.05f, -0.05f, 4.45f);
        }


        //icy cube dragon
        cameraIceCubeD.setPosition(0.0f, 0.2f, 1.5f);
        cameraIceCubeD.setRotation((float) java.lang.Math.toRadians(0.0f), (float) java.lang.Math.toRadians(0.0f));

        //code
        //scale - rotasi - traslate --> untuk program
        //translate - rotasi - scale --> biasanya

//        background.add(new Sphere_IceCubeD(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.2f,0.6f,1.0f,0.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f,36,18,1
//        ));
//        background.add(new Sphere_IceCubeD(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.950f,0.813f,0.608f,0.0f),
//                new Vector3f(0.0f, -0.5f, 0.0f),50.0f, 1.0f, 50.0f,36,18,1
//        ));
//        background.add(new Sphere_IceCubeD(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                new Vector3f(0.0f, -0.5f, 0.0f),10.0f, 10.0f, 10.0f,36,18,0
//        ));
//        background.get(2).translateObject(0.5f,0.5f,0.0f);
//        background.get(2).scaleObject(10f,5f,10f);
//        background.add(new Sphere_IceCubeD(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                new Vector3f(0.0f, -0.5f, 0.0f),10.0f, 10.0f, 10.0f,36,18,0
//        ));
//        background.get(3).translateObject(0.35f,0.5f,0.0f);
//        background.get(3).scaleObject(10f,5f,10f);
//        background.get(0).translateObject(0.0f,0.0f,-25.0f);
//        background.get(1).translateObject(0.0f,0.0f,-25.0f);
//        background.get(1).scaleObject(4.0f,4.0f,4.0f);

        //Badan
        objectIceCubeDS.add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.65f, 0.95f, 0.85f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18,
                1
        ));
        objectIceCubeDS.get(0).translateObject(0.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).scaleObject(2.5f, 2.5f, 2.5f);

        //Tangan kiri
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert.glsl"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag.glsl"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                1.0f,
                1.25f,
                1.2f,
                36,
                18,
                2
        ));
        objectIceCubeDS.get(0).getChildObject().get(0).translateObject(-0.45f, -0.1f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(0).scaleObject(1.45f, 1.45f, 1.45f);

        //Jari tangan kiri
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-2.2f, -5.3f, -0.65f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), -15.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.3f, 0.1f, 0.3f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-2.3f, -6.5f, -0.7f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(1.0f), -12.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.3f, 0.1f, 0.3f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-2.4f, -6.8f, -0.72f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(1.0f), -8.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.3f, 0.1f, 0.3f);

        //Tangan kanan
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.0f,
                0.0f,
                0.0f,
                36,
                18,
                2
        ));
        objectIceCubeDS.get(0).getChildObject().get(1).translateObject(0.45f, -0.1f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(1).scaleObject(1.45f, 1.45f, 1.45f);

        //Jari tangan Kanan
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(2.2f, -5.3f, -0.65f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), -15.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.3f, 0.1f, 0.3f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(2.3f, -6.5f, -0.7f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(1.0f), -12.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.3f, 0.1f, 0.3f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                6
        ));
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(2).translateObject(2.4f, -6.8f, -0.72f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(1.0f), -8.0f, 0.0f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(1).getChildObject().get(2).scaleObject(0.3f, 0.1f, 0.3f);

        objectIceCubeDS.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -25.0f);
        objectIceCubeDS.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 25.0f);


        //Mata
        //--hitam
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(2).translateObject(-0.22f, 0.135f, 0.59f);
        objectIceCubeDS.get(0).getChildObject().get(2).scaleObject(1.8f, 2.35f, 1.005f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(3).translateObject(0.18f, 0.135f, 0.59f);
        objectIceCubeDS.get(0).getChildObject().get(3).scaleObject(1.8f, 2.35f, 1.005f);
        //--putih
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(4).translateObject(-0.26f, 0.16f, 0.6f);
        objectIceCubeDS.get(0).getChildObject().get(4).scaleObject(1.5f, 2.0f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(5).translateObject(0.22f, 0.16f, 0.6f);
        objectIceCubeDS.get(0).getChildObject().get(5).scaleObject(1.5f, 2.0f, 1.0f);
        //--baby pink
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.8f, 0.0f, 0.4f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(6).translateObject(-0.33f, 0.21f, 0.61f);
        objectIceCubeDS.get(0).getChildObject().get(6).scaleObject(1.15f, 1.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.8f, 0.0f, 0.4f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(7).translateObject(0.28f, 0.2f, 0.61f);
        objectIceCubeDS.get(0).getChildObject().get(7).scaleObject(1.15f, 1.5f, 1.0f);
        //--pupil hitam
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(8).translateObject(-0.34f, 0.24f, 0.43f);
        objectIceCubeDS.get(0).getChildObject().get(8).scaleObject(1.1f, 1.3f, 1.3f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(9).translateObject(0.3f, 0.24f, 0.43f);
        objectIceCubeDS.get(0).getChildObject().get(9).scaleObject(1.1f, 1.3f, 1.3f);
        //--tambahan putih
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(10).translateObject(-1.48f, 0.675f, 0.623f);
        objectIceCubeDS.get(0).getChildObject().get(10).scaleObject(0.3f, 0.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(11).translateObject(1.28f, 0.56f, 0.623f);
        objectIceCubeDS.get(0).getChildObject().get(11).scaleObject(0.3f, 0.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(12).translateObject(-0.98f, 0.57f, 0.623f);
        objectIceCubeDS.get(0).getChildObject().get(12).scaleObject(0.3f, 0.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(13).translateObject(0.8f, 0.66f, 0.623f);
        objectIceCubeDS.get(0).getChildObject().get(13).scaleObject(0.3f, 0.5f, 1.0f);

        //pipi - pink
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert.glsl"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag.glsl"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.9f, 0.9f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(14).translateObject(-0.37f, 0.002f, 0.47f);
        objectIceCubeDS.get(0).getChildObject().get(14).scaleObject(1.2f, 1.0f, 1.25f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert.glsl"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag.glsl"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.9f, 0.9f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(15).translateObject(0.35f, 0.002f, 0.47f);
        objectIceCubeDS.get(0).getChildObject().get(15).scaleObject(1.2f, 1.0f, 1.25f);

        //Kaki
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                4
        ));
        objectIceCubeDS.get(0).getChildObject().get(16).translateObject(-0.2f, -0.3f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(16).scaleObject(2.0f, 2.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                4
        ));
        objectIceCubeDS.get(0).getChildObject().get(17).translateObject(0.2f, -0.3f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(17).scaleObject(2.0f, 2.5f, 1.0f);

        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).translateObject(-0.18f, -0.55f, 0.03f);
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).scaleObject(2.2f, 1.6f, 3.0f);
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).translateObject(0.18f, -0.55f, 0.03f);
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).scaleObject(2.2f, 1.6f, 3.0f);
        //jari kaki kiri
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(0).translateObject(-0.7f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(0).scaleObject(0.4f, 0.6f, 1.4f);

        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(1).translateObject(-1.2f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(1).scaleObject(0.4f, 0.6f, 1.4f);

        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(2).translateObject(-0.95f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(16).getChildObject().get(0).getChildObject().get(2).scaleObject(0.4f, 0.6f, 1.4f);
        //jari kaki kanan
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(0).translateObject(0.7f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(0).scaleObject(0.4f, 0.6f, 1.4f);

        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(1).translateObject(1.2f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(1).scaleObject(0.4f, 0.6f, 1.4f);

        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.5f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                8
        ));
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(2).translateObject(0.95f, -1.55f, 0.2f);
        objectIceCubeDS.get(0).getChildObject().get(17).getChildObject().get(0).getChildObject().get(2).scaleObject(0.4f, 0.6f, 1.4f);


        //tail
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.4f, 0.698f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                36,
                18,
                5
        ));
        objectIceCubeDS.get(0).getChildObject().get(18).translateObject(0.0f, -0.15f, -3.5f);
        objectIceCubeDS.get(0).getChildObject().get(18).scaleObject(1.5f, 1.5f, 0.3f);

        //mulut
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(19).translateObject(0.0f, -0.17f, 0.6f);
        objectIceCubeDS.get(0).getChildObject().get(19).scaleObject(1.5f, 1.5f, 1.0f);

        //Dot
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 0.498f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(20).translateObject(0.0f, -0.1f, 0.635f);
        objectIceCubeDS.get(0).getChildObject().get(20).scaleObject(2.5f, 2.5f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.6f, 0.8f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                3
        ));
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(0).translateObject(0.0f, -0.35f, 0.71f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(0).scaleObject(1.0f, 0.7f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.6f, 0.8f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                4
        ));
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(1).translateObject(0.0f, -0.35f, 0.85f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(1).scaleObject(1.4f, 0.7f, 1.0f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.75f, 0.75f, 0.75f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                4
        ));
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(2).translateObject(0.0f, -0.45f, 1.7f);
        objectIceCubeDS.get(0).getChildObject().get(20).getChildObject().get(2).scaleObject(0.4f, 0.5f, 0.5f);

        //Wing - left
        objectIceCubeDS.get(0).getChildObject().add(new Curve_wing_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.3f,
                0.3f,
                0.3f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(21).translateObject(-2.5f, -0.45f, -0.25f);
        objectIceCubeDS.get(0).getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f), 30.0f, -10.0f, -40.0f);
        objectIceCubeDS.get(0).getChildObject().get(21).scaleObject(0.2f, 1.5f, 1.5f);
        //Wing - right
        objectIceCubeDS.get(0).getChildObject().add(new Curve_wing_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.3f,
                0.3f,
                0.3f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(22).translateObject(2.5f, -0.45f, -0.25f);
        objectIceCubeDS.get(0).getChildObject().get(22).rotateObject((float) Math.toRadians(0.5f), 30.0f, 10.0f, 40.0f);
        objectIceCubeDS.get(0).getChildObject().get(22).scaleObject(0.2f, 1.5f, 1.5f);

        //horn
        objectIceCubeDS.get(0).getChildObject().add(new Curve_wing_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.3f,
                0.3f,
                0.3f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(23).translateObject(0.0f, 0.9f, 0.6f);
        objectIceCubeDS.get(0).getChildObject().get(23).scaleObject(0.8f, 0.8f, 0.8f);
        //poros tangan kiri
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(24).translateObject(-1.1f, 0.7f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(24).scaleObject(0.5f, 0.5f, 0.5f);
        //poros tangan kanan
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(25).translateObject(1.1f, 0.7f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(25).scaleObject(0.5f, 0.5f, 0.5f);
        //poros kaki kiri
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(26).translateObject(-0.75f, -1.2f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(26).scaleObject(0.5f, 0.5f, 0.5f);
        //poros kaki kanan
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(27).translateObject(0.75f, -1.2f, 0.0f);
        objectIceCubeDS.get(0).getChildObject().get(27).scaleObject(0.5f, 0.5f, 0.5f);
        //poros sayap kiri
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(28).translateObject(-1.1f, 1.0f, -1.1f);
        objectIceCubeDS.get(0).getChildObject().get(28).scaleObject(0.5f, 0.5f, 0.5f);
        //poros sayap kanan
        objectIceCubeDS.get(0).getChildObject().add(new Sphere_IceCubeD(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1f, 1f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18,
                0
        ));
        objectIceCubeDS.get(0).getChildObject().get(29).translateObject(1.1f, 1.0f, -1.1f);
        objectIceCubeDS.get(0).getChildObject().get(29).scaleObject(0.5f, 0.5f, 0.5f);
        //icy scale
        objectIceCubeDS.get(0).scaleObject(0.18f, 0.18f, 0.18f);
        objectIceCubeDS.get(0).translateObject(0.05f, 0.0f, 0.33f);


        //lego block dragon
        camera.setPosition(0.0f, 0.0f, 2.0f);
        camera.setRotation(((float) java.lang.Math.toRadians(0.0f)), ((float) java.lang.Math.toRadians(0.0f)));
        //code
//        background.add(new SquareBlockDragon(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.6f,1.0f,1.0f,0.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f
//        ));
//        background.add(new SquareBlockDragon(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.950f,0.813f,0.608f,0.0f),
//                new Vector3f(0.0f, -0.5f, 0.0f),50.0f, 1.0f, 50.0f
//        ));
//        //code
//        background.add(new SquareBlockDragon(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.6f,1.0f,1.0f,0.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),50.0f, 50.0f, 50.0f
//        ));
//        background.add(new SquareBlockDragon(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert.glsl"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag.glsl"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.950f,0.813f,0.608f,0.0f),
//                new Vector3f(0.0f, -0.5f, 0.0f),50.0f, 1.0f, 50.0f
//        ));

        // mid body
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.37f, 0.1f, 0.39f
        ));
        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));

        // upper body
        blockDragon.get(0).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.7f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.38f, 0.2f, 0.4f
        ));
        blockDragon.get(0).getChildObject().get(0).translateObject(0.0f, 0.12f, 0.0f);

        // lower body
        blockDragon.get(0).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.7f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.38f, 0.13f, 0.4f
        ));
        blockDragon.get(0).getChildObject().get(1).translateObject(0.0f, -0.076f, 0.0f);

        // head (lower jaw)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.0f, 0.18f, 0.05f),
                0.4f, 0.1f, 0.35f
        ));

        // head (upper)
        blockDragon.get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.0f, 0.3f, 0.05f),
                0.35f, 0.12f, 0.33f
        ));
        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.3f, -0.28f),
                0.05f, 0.05f, 0.05f
        ));

        blockDragon.get(1).getChildObject().get(0).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(-0.075f, 0.37f, 0.15f),
                0.05f, 0.05f, 0.05f
        ));
        blockDragon.get(1).getChildObject().get(0).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.075f, 0.37f, 0.15f),
                0.05f, 0.05f, 0.05f
        ));

        // right eye
        blockDragon.get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.20f, 0.34f, -0.05f),
                0.05f, 0.15f, 0.15f
        ));
        blockDragon.get(1).getChildObject().get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.20f, 0.39f, -0.15f),
                0.05f, 0.05f, 0.05f
        ));

        // right eye pupils
        blockDragon.get(1).getChildObject().get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 1.0f, 0.0f, 0.0f),
                new Vector3f(-0.21f, 0.34f, -0.05f),
                0.05f, 0.12f, 0.12f
        ));
        blockDragon.get(1).getChildObject().get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.5f, 0.1f, 0.0f),
                new Vector3f(-0.22f, 0.33f, -0.04f),
                0.05f, 0.10f, 0.10f
        ));
        blockDragon.get(1).getChildObject().get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(-0.23f, 0.33f, -0.03f),
                0.05f, 0.07f, 0.07f
        ));

        // left eye
        blockDragon.get(1).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.20f, 0.34f, -0.05f),
                0.05f, 0.15f, 0.15f
        ));
        blockDragon.get(1).getChildObject().get(2).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.20f, 0.39f, -0.15f),
                0.05f, 0.05f, 0.05f
        ));


        // left eye pupils
        blockDragon.get(1).getChildObject().get(2).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 1.0f, 0.0f, 0.0f),
                new Vector3f(0.21f, 0.34f, -0.05f),
                0.05f, 0.12f, 0.12f
        ));
        blockDragon.get(1).getChildObject().get(2).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.5f, 0.1f, 0.0f),
                new Vector3f(0.22f, 0.33f, -0.04f),
                0.05f, 0.10f, 0.10f
        ));
        blockDragon.get(1).getChildObject().get(2).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.23f, 0.33f, -0.03f),
                0.05f, 0.07f, 0.07f
        ));

        // left feet (index = 2)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.1f, -0.2f, 0.0f),
                0.1f, 0.07f, 0.3f
        ));

        blockDragon.get(2).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.1f, -0.15f, -0.05f),
                0.1f, 0.07f, 0.1f
        ));

        blockDragon.get(2).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.125f, -0.21f, 0.18f),
                0.03f, 0.05f, 0.06f
        ));

        blockDragon.get(2).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.075f, -0.21f, 0.18f),
                0.03f, 0.05f, 0.06f
        ));


        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.3f, -0.28f),
                0.05f, 0.05f, 0.05f
        ));

        // right feet (index = 3)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.1f, -0.2f, 0.0f),
                0.1f, 0.07f, 0.3f
        ));

        blockDragon.get(3).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.1f, -0.15f, -0.05f),
                0.1f, 0.07f, 0.1f
        ));

        blockDragon.get(2).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(-0.125f, -0.21f, 0.18f),
                0.03f, 0.05f, 0.06f
        ));

        blockDragon.get(2).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(-0.075f, -0.21f, 0.18f),
                0.03f, 0.05f, 0.06f
        ));

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.3f, -0.28f),
                0.05f, 0.05f, 0.05f
        ));

        // left hand (index = 4)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(-0.3f, 0.065f, 0.0f),
                0.2f, 0.06f, 0.14f
        ));

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));
        anchorPoint.get(4).translateObject(-0.15f, 0.065f, 0.0f);

        blockDragon.get(4).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));
        Vector3f pos = anchorPoint.get(4).model.transformPosition(new Vector3f());

        blockDragon.get(4).getChildObject().get(0).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(4).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
        }
        blockDragon.get(4).getChildObject().get(0).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(4).getChildObject().get(0).translateObject(-0.2f, -0.12f, 0.3f);

        blockDragon.get(4).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));

        blockDragon.get(4).getChildObject().get(1).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(4).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
        }
        blockDragon.get(4).getChildObject().get(1).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(4).getChildObject().get(1).translateObject(-0.2f, -0.12f, 0.35f);

        blockDragon.get(4).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(-0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));


        blockDragon.get(4).getChildObject().get(2).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(4).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
        }
        blockDragon.get(4).getChildObject().get(2).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(4).getChildObject().get(2).translateObject(-0.2f, -0.12f, 0.4f);

        blockDragon.get(4).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 30; i++) {
            blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
        }
        blockDragon.get(4).translateObject(pos.x, pos.y, -pos.z);

        blockDragon.get(4).getChildObject().add(new SphereBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.12f, 0.08f, 0.12f
        ));
        blockDragon.get(4).getChildObject().get(3).translateObject(-0.15f, 0.05f, 0.0f);

        // right hand (index = 5)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.3f, 0.065f, 0.0f),
                0.2f, 0.06f, 0.14f
        ));

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));
        anchorPoint.get(5).translateObject(0.15f, 0.065f, 0.0f);

        blockDragon.get(5).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));
        pos = anchorPoint.get(5).model.transformPosition(new Vector3f());

        blockDragon.get(5).getChildObject().get(0).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(5).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
        }
        blockDragon.get(5).getChildObject().get(0).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(5).getChildObject().get(0).translateObject(0.2f, -0.12f, 0.3f);

        blockDragon.get(5).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));

        blockDragon.get(5).getChildObject().get(1).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(5).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
        }
        blockDragon.get(5).getChildObject().get(1).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(5).getChildObject().get(1).translateObject(0.2f, -0.12f, 0.35f);

        blockDragon.get(5).getChildObject().add(new PawBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.5f, 0.2f, 0.07f),
                0.03f, 0.05f, 0.06f
        ));


        blockDragon.get(5).getChildObject().get(2).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 90; i++) {
            blockDragon.get(5).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
        }
        blockDragon.get(5).getChildObject().get(2).translateObject(pos.x, pos.y, -pos.z);
        blockDragon.get(5).getChildObject().get(2).translateObject(0.2f, -0.12f, 0.4f);


        blockDragon.get(5).translateObject(-pos.x, -pos.y, pos.z);
        for (int i = 0; i < 30; i++) {
            blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
        }
        blockDragon.get(5).translateObject(pos.x, pos.y, -pos.z);

        blockDragon.get(5).getChildObject().add(new SphereBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.9f, 0.2f, 0.3f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.12f, 0.08f, 0.12f
        ));
        blockDragon.get(5).getChildObject().get(3).translateObject(0.15f, 0.05f, 0.0f);

        // left wing (index = 6)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(0.32f, 0.1f, -0.28f),
                0.35f, 0.1f, 0.05f
        ));
        blockDragon.get(6).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.6f, 0.9f, 0.0f),
                new Vector3f(0.25f, 0.0f, -0.28f),
                0.25f, 0.08f, 0.05f
        ));

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));
        anchorPoint.get(6).translateObject(0.05f, 0.03f, -0.28f);

        blockDragon.get(6).translateObject(-0.05f, -0.03f, 0.28f);
        blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 30.0f);
        blockDragon.get(6).translateObject(0.05f, 0.03f, -0.28f);

        blockDragon.get(6).getChildObject().get(0).translateObject(-0.05f, -0.03f, 0.28f);
        blockDragon.get(6).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -10.0f);
        blockDragon.get(6).getChildObject().get(0).translateObject(0.05f, 0.03f, -0.28f);

        // rightt wing (index = 7)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.4f, 0.9f, 0.0f),
                new Vector3f(-0.32f, 0.1f, -0.28f),
                0.35f, 0.1f, 0.05f
        ));
        blockDragon.get(7).getChildObject().add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.6f, 0.9f, 0.0f),
                new Vector3f(-0.25f, 0.0f, -0.28f),
                0.25f, 0.08f, 0.05f
        ));

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));

        anchorPoint.get(7).translateObject(-0.05f, 0.03f, -0.28f);

        blockDragon.get(7).translateObject(0.05f, 0.03f, 0.28f);
        blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -30.0f);
        blockDragon.get(7).translateObject(-0.05f, -0.03f, -0.28f);

        blockDragon.get(7).getChildObject().get(0).translateObject(0.05f, 0.03f, 0.28f);
        blockDragon.get(7).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 10.0f);
        blockDragon.get(7).getChildObject().get(0).translateObject(-0.05f, -0.03f, -0.28f);

        // chair (index = 8)
        blockDragon.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.6f, 0.3f, 0.1f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.6f, 0.05f, 0.6f
        ));
        blockDragon.get(8).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.6f, 0.3f, 0.1f, 0.0f),
                new Vector3f(-0.15f, -0.13f, 0.2f),
                0.05f, 0.21f, 0.05f
        ));
        blockDragon.get(8).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.6f, 0.3f, 0.1f, 0.0f),
                new Vector3f(0.15f, -0.13f, 0.2f),
                0.05f, 0.21f, 0.05f
        ));
        blockDragon.get(8).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.6f, 0.3f, 0.1f, 0.0f),
                new Vector3f(-0.15f, -0.13f, -0.2f),
                0.05f, 0.21f, 0.05f
        ));
        blockDragon.get(8).getChildObject().add(new TubeBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.6f, 0.3f, 0.1f, 0.0f),
                new Vector3f(0.15f, -0.13f, -0.2f),
                0.05f, 0.21f, 0.05f
        ));

        blockDragon.get(8).scaleObject(0.1f, 0.1f, 0.1f);

        anchorPoint.add(new SquareBlockDragon(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert.glsl"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag.glsl"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of()
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.05f, 0.05f, 0.05f
        ));
        //lego scale
        for (ObjectBlockDragon blockDragon1 : blockDragon) {
            blockDragon1.scaleObject(0.5f, 0.5f, 0.5f);
            blockDragon1.translateObject(0.03f, 0.3f, 0.45f);
        }
        for (ObjectBlockDragon anchor : anchorPoint) {
            anchor.scaleObject(0.5f, 0.5f, 0.5f);
            anchor.translateObject(0.03f, 0.3f, 0.45f);
        }


        //maki dragon
        camera_Kristofer.setPosition(0.55f, 0.0f, 1.5f);
        camera_Kristofer.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
        objectsMakiDragon_Kristofer.add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.4f,
                0.5f
        ));
        objectsMakiDragon_Kristofer.get(0).scaleObject(0.2f, 0.2f, 0.2f);
        //bagian depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.13f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).scaleObject(0.15f, 0.15f, 0.15f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.04f);
        //bagian belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.01f,
                0.2f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(1).scaleObject(0.15f, 0.15f, 0.15f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(1).translateObject(0.0f, 0.0f, -0.042f);

        //mata
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.08f, 0.08f, 0.08f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.05f);

        //pupil atas
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f, 0.0204f, 0.0630f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.05f, 0.05f, 0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(Math.toRadians(20), 0.0f, 0.0f, 1f);
        //pupil bawah
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f, 0.0204f, 0.0630f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.05f, 0.05f, 0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, 0.0f, 0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(Math.toRadians(130), 0.0f, 0.0f, 1f);
        //titik putih
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.4f,
                0.0f,
                0.09f

        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.025f, 0.025f, 0.025f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.02f, 0.0f, 0.054f);

        //Mulut
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.340f, 0.0204f, 0.0630f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.04f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, 0.055f, 0.05f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(Math.toRadians(180), 0.0f, 0.0f, 1f);
        //gigi kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.01f, 0.01f, 0.01f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.01f, 0.055f, 0.053f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject(Math.toRadians(180), 0.0f, 0.0f, 1f);
        //gigi kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.01f, 0.01f, 0.01f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.01f, 0.055f, 0.053f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).rotateObject(Math.toRadians(180), 0.0f, 0.0f, 1f);

        //lidah
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Tube_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.0f,
                0.09f,
                0f
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).scaleObject(0.014f, 0.014f, 0.014f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(0.00f, -0.076f, 0.052f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject(Math.toRadians(0), 0.0f, 0.0f, 1f);

        //tanduk kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.985f, 0.120f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).scaleObject(0.02f, 0.02f, 0.02f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(50), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(2).translateObject(0.0f, 0.16f, 0.0f);

        //tanduk kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.985f, 0.120f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).scaleObject(0.02f, 0.02f, 0.02f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(-230), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(3).translateObject(0.155f, 0.03f, 0.0f);

        //kaki kanan depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).scaleObject(0.015f, 0.015f, 0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(250), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).translateObject(-0.04f, -0.137f, 0.03f);

        //kaki kanan belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).scaleObject(0.015f, 0.015f, 0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(250), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).translateObject(-0.04f, -0.137f, -0.02f);

        //kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).scaleObject(0.015f, 0.015f, 0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(295), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).translateObject(-0.15f, -0.06f, 0.03f);

        //kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Sphere_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).scaleObject(0.015f, 0.015f, 0.015f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(0.0f, 0.1f, -0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(180), 0.0f, 0.0f, -1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(295), 1.0f, 0.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).translateObject(-0.15f, -0.06f, -0.02f);

        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).scaleObject(0.03f, 0.06f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(255), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).translateObject(-0.11f, 0.05f, 0.0f);

        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).scaleObject(0.03f, 0.06f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).rotateObject(Math.toRadians(120), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().get(0).translateObject(-0.15f, 0.05f, 0.0f);
        //sayap kiri
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).getChildObject().add(new plane_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f)
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
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).scaleObject(0.03f, 0.06f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(255), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).translateObject(-0.11f, 0.05f, 0.0f);
        //sayap kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().add(new Elipsoid_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.55f,
                0.55f,
                0.5f, 36,
                30
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).scaleObject(0.03f, 0.06f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).rotateObject(Math.toRadians(120), 0.0f, 0.0f, 1.0f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().get(0).translateObject(-0.15f, 0.05f, 0.0f);
        //sayap kanan
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).getChildObject().add(new plane_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.228f, 0.299f, 1.0f)
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
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(10).translateObject(-0.05f, 0.02f, 0.0f);

        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(11).translateObject(0.05f, 0.02f, 0.0f);

        //poros kaki kanan depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(12).translateObject(0.05f, -0.07f, 0.02f);
        //poros kaki kanan belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(13).translateObject(0.05f, -0.07f, -0.02f);
        //poros kaki kiri depan
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(14).translateObject(-0.05f, -0.07f, 0.02f);
        //poros kaki kiri belakang
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));
        //
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(15).translateObject(-0.05f, -0.07f, -0.02f);

        //poros mata
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).translateObject(0.0f, 0.0f, 0.049f);

        //poros alis
        objectsMakiDragon_Kristofer.get(0).getChildObject().add(new Box_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.00820f, 0.410f, 0.142f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18
        ));

        objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).scaleObject(0.03f, 0.03f, 0.03f);
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).translateObject(0.0f, 0.055f, 0.049f);

        //alis
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().add(new Curve_Kristofer(
                Arrays.asList(
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.vert.glsl", GL_VERTEX_SHADER),
                        new ShaderProgram_Kristofer.ShaderModuleData("resources/shaders/scene.frag.glsl", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f)
        ));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(-0.04f, 0.04f, 0.052f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.0f, 0.07f, 0.052f));
        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).addVertices(new Vector3f(0.04f, 0.04f, 0.052f));

        //maki scale
        objectsMakiDragon_Kristofer.get(0).translateObject(0.23f, 0.03f, 0.0f);

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


    public void input_Gummy() {


        if (window.isKeyPressed(GLFW_KEY_K)) {
            if (temp == 0) {

                float x1 = dragon.get(19).getMatrix().get(3, 0);
                float x2 = dragon.get(19).getMatrix().get(3, 1);
                float x3 = dragon.get(19).getMatrix().get(3, 2);
                dragon.get(11).translateObject(-x1, -x2, -x3);
                dragon.get(11).rotateObject((float) java.lang.Math.toRadians(0.5f), 1.0f, 0f, 0f);
                dragon.get(11).translateObject(x1, x2, x3);

                float x4 = dragon.get(19).getMatrix().get(3, 0);
                float x5 = dragon.get(19).getMatrix().get(3, 1);
                float x6 = dragon.get(19).getMatrix().get(3, 2);
                dragon.get(12).translateObject(-x4, -x5, -x6);
                dragon.get(12).rotateObject((float) java.lang.Math.toRadians(0.5f), 1.0f, 0f, 0f);
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
            dragon.get(11).rotateObject((float) java.lang.Math.toRadians(-0.5f), 1.0f, 0f, 0f);
            dragon.get(11).translateObject(x1, x2, x3);

            float x4 = dragon.get(19).getMatrix().get(3, 0);
            float x5 = dragon.get(19).getMatrix().get(3, 1);
            float x6 = dragon.get(19).getMatrix().get(3, 2);
            dragon.get(12).translateObject(-x4, -x5, -x6);
            dragon.get(12).rotateObject((float) java.lang.Math.toRadians(-0.5f), 1.0f, 0f, 0f);
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
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

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
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

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
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

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
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            float x1 = dragon.get(0).getMatrix().get(3, 0);
            float x2 = dragon.get(0).getMatrix().get(3, 1);
            float x3 = dragon.get(0).getMatrix().get(3, 2);
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(-x1, -x2, -x3);

            }

            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) java.lang.Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(x1, x2, x3);

            }


        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            float x1 = dragon.get(0).getMatrix().get(3, 0);
            float x2 = dragon.get(0).getMatrix().get(3, 1);
            float x3 = dragon.get(0).getMatrix().get(3, 2);
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(-x1, -x2, -x3);

            }

            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) java.lang.Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);

            }
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(x1, x2, x3);

            }

        }
        if (window.isKeyPressed(GLFW_KEY_H)) {
            float x1 = dragon.get(0).getMatrix().get(3, 0);
            float x2 = dragon.get(0).getMatrix().get(3, 1);
            float x3 = dragon.get(0).getMatrix().get(3, 2);
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(-x1, -x2, -x3);

            }

            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) java.lang.Math.toRadians(-1.0f), 1.0f, 0.0f, 0.0f);

            }
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(x1, x2, x3);

            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            float x1 = dragon.get(0).getMatrix().get(3, 0);
            float x2 = dragon.get(0).getMatrix().get(3, 1);
            float x3 = dragon.get(0).getMatrix().get(3, 2);
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(-x1, -x2, -x3);

            }

            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).rotateObject((float) java.lang.Math.toRadians(-1.0f), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < dragon.size(); i++) {

                dragon.get(i).translateObject(x1, x2, x3);

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
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            dragon.get(1).translateObject(-pos1, -pos2, pos3);
            dragon.get(2).translateObject(-pos4, -pos5, pos6);

            if (!batasBawah) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                titikSumbuZ++;
            } else if (!batasAtas) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                titikSumbuZ--;
            }

            dragon.get(1).translateObject(pos1, pos2, -pos3);
            dragon.get(2).translateObject(pos4, pos5, -pos6);

            for (int i = 0; i < perputaranSumbuX; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            for (int i = 0; i < perputaranSumbuY; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

            }
            for (int i = 0; i < perputaranSumbuZ; i++) {
                dragon.get(1).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                dragon.get(2).rotateObject(((float) java.lang.Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

            }


        }

    }

    public void batas_sayap_Kristofer() {
        batas_atasrotasi_Kristofer = rotasisayap_Kristofer + 15;
        batas_bawahrotasi_Kristofer = rotasisayap_Kristofer - 15;
    }

    public void input_Kris() {
        if (window.isKeyPressed(GLFW_KEY_1)) {
            camZ += 0.1f;
            camera_Kristofer.moveForward((float) Math.toRadians(0.1f));
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
        if (window.isKeyPressed(GLFW_KEY_2)) {
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
        if (window.isKeyPressed(GLFW_KEY_3)) {
            camZ -= 0.1f;
            camera_Kristofer.moveBackwards((float) Math.toRadians(0.1f));
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
        if (window.isKeyPressed(GLFW_KEY_4)) {
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

        //BELUM DI UBAHHH!!!
//        if(window.isKeyPressed(GLFW_KEY_Q)){
//            camX -= 0.1f;
//            camera_Kristofer.moveUp((float) Math.toRadians(0.1f));
//        }
//        if(window.isKeyPressed(GLFW_KEY_E)){
//            camX += 0.1f;
//            camera_Kristofer.moveDown((float) Math.toRadians(0.1f));
//        }
//        if(window.isKeyPressed(GLFW_KEY_R)){
//            degreecamX += 0.1f;
//            camera_Kristofer.addRotation((float)Math.toRadians(0.1f), (float)Math.toRadians(0.0f));
//        }
//        if(window.isKeyPressed(GLFW_KEY_T)){
//            degreecamX -= 0.1f;
//            camera_Kristofer.addRotation((float)Math.toRadians(-0.1f), (float)Math.toRadians(0.0f));
//        }
//        if(window.isKeyPressed(GLFW_KEY_Y)){
//            degreecamY += 0.1f;
//            camera_Kristofer.addRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(0.1f));
//        }
//        if(window.isKeyPressed(GLFW_KEY_U)){
//            degreecamY -= 0.1f;
//            camera_Kristofer.addRotation((float)Math.toRadians(0.0f), (float)Math.toRadians(-0.1f));
//        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);

            for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                obj.rotateObject((float) Math.toRadians(1), 1f, 0f, 0f);
            }

            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x, pos1.y, pos1.z);
            degreeY_Kristofer -= Math.toRadians(1);
            if (degreeY_Kristofer < 0) {
                degreeY_Kristofer = 359;
            }
            batas_sayap_Kristofer();
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);

            for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                obj.rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                ;
            }
            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x, pos1.y, pos1.z);
            degreeX_Kristofer += Math.toRadians(1);
            if (degreeX_Kristofer > 359) {
                degreeX_Kristofer = 0;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_H)) {
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);

            for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                obj.rotateObject((float) Math.toRadians(1f), -1f, 0f, 0f);
            }

            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x, pos1.y, pos1.z);
            degreeY_Kristofer += Math.toRadians(1);
            if (degreeY_Kristofer > 359) {
                degreeY_Kristofer = 0;
            }
            batas_sayap_Kristofer();
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());

            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x, -pos1.y, -pos1.z);
            for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                obj.rotateObject((float) Math.toRadians(1f), 0f, 1f, 0f);
            }
            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x, pos1.y, pos1.z);
            degreeX_Kristofer -= Math.toRadians(1);
            if (degreeX_Kristofer < 0) {
                degreeX_Kristofer = 359;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            if (temp_z_Kristofer < batas_depan_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, 0.01f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, 0.01f);
                }
                temp_z_Kristofer += 0.01f;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            if (temp_z_Kristofer > batas_belakang_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, -0.01f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(0.0f, 0.0f, -0.01f);
                }
                temp_z_Kristofer -= 0.01f;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            if (temp_x_Kristofer > batas_kiri_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(-0.01f, 0.0f, 0.0f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(-0.01f, 0.0f, 0.0f);
                }
                temp_x_Kristofer -= 0.01f;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            if (temp_x_Kristofer < batas_kanan_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(+0.01f, 0.0f, 0.0f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(0.01f, 0.0f, 0.0f);
                }
                temp_x_Kristofer += 0.01f;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_4)) {
            if (temp_y_Kristofer > batas_bawah_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, -0.01f, 0.0f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(0.0f, -0.01f, 0.0f);
                }
                tempY_Kristofer -= 0.01f;
                temp_y_Kristofer -= 0.01f;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_5)) {
            if (temp_y_Kristofer < batas_atas_Kristofer) {
                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
                    obj.translateObject(0.0f, 0.01f, 0.0f);
                }
                for (Object_Kristofer obj : anchorpoint_Kristofer) {
                    obj.translateObject(0.0f, 0.01f, 0.0f);
                }
                tempY_Kristofer += 0.01f;
                temp_y_Kristofer += 0.01f;
            }

        }
        //belum di ubah!!!
//        if(window.isKeyPressed(GLFW_KEY_M)){
//            if(temp_x_Kristofer > batas_kiri_Kristofer) {
//                for (Object_Kristofer obj : objectsMakiDragon_Kristofer) {
//                    obj.translateObject(-0.01f, 0.0f, 0.0f);
//                }
//                temp_x_Kristofer -= 0.01f;
//            }
//            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).model.transformPosition(new Vector3f());
//            objectsMakiDragon_Kristofer.get(0).translateObject(-pos1.x,-pos1.y,-pos1.z);
//            for(Object_Kristofer obj: objectsMakiDragon_Kristofer){
//                obj.rotateObject((float) Math.toRadians(1f), 0f, -1f,0f);;
//            }
//            objectsMakiDragon_Kristofer.get(0).translateObject(pos1.x,pos1.y,pos1.z);
//            degreeX_Kristofer += Math.toRadians(1f);
//        }

        if (window.isKeyPressed(GLFW_KEY_Y)) {
            Vector3f poscenter = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).model.transformPosition(new Vector3f());
            //mata
            Vector3f poros1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(16).model.transformPosition(new Vector3f());
            Vector3f poros2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(17).model.transformPosition(new Vector3f());
            Vector3f pos1 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).model.transformPosition(new Vector3f());

            if (obj_temp_Kristofer.size() < 20 && !done_scale_Kristofer) {
                obj_temp_Kristofer.add(objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0));

                tempx_Kristofer = degreeX_Kristofer;
                tempy_Kristofer = degreeY_Kristofer;
                tempz_Kristofer = degreeZ_Kristofer;

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                while (tempx_Kristofer > 0) {
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                    tempx_Kristofer--;
                }

                while (tempy_Kristofer > 0) {
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    tempy_Kristofer--;
                }

                while (tempz_Kristofer > 0) {
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

                while (tempx_Kristofer < degreeX_Kristofer) {
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                    tempx_Kristofer++;
                }

                while (tempy_Kristofer < degreeY_Kristofer) {
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                    tempy_Kristofer++;
                }

                while (tempz_Kristofer < degreeZ_Kristofer) {
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

                    tempz_Kristofer++;
                }

                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

            } else if (obj_temp_Kristofer.size() == 20 && !done_scale_Kristofer) {
                done_scale_Kristofer = true;
                obj_temp_Kristofer.add(objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0));
            } else {
                if (obj_temp_Kristofer.size() == 0) {
                    done_scale_Kristofer = false;
                    tempx_Kristofer = degreeX_Kristofer;
                    tempy_Kristofer = degreeY_Kristofer;
                    tempz_Kristofer = degreeZ_Kristofer;

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                    while (tempx_Kristofer > 0) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        tempx_Kristofer--;
                    }

                    while (tempy_Kristofer > 0) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        tempy_Kristofer--;
                    }

                    while (tempz_Kristofer > 0) {
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

                    while (tempx_Kristofer < degreeX_Kristofer) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                        tempx_Kristofer++;
                    }

                    while (tempy_Kristofer < degreeY_Kristofer) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                        tempy_Kristofer++;
                    }

                    while (tempz_Kristofer < degreeZ_Kristofer) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);

                        tempz_Kristofer++;
                    }

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);

                } else {
                    obj_temp_Kristofer.remove(obj_temp_Kristofer.size() - 1);
                    tempx_Kristofer = degreeX_Kristofer;
                    tempy_Kristofer = degreeY_Kristofer;
                    tempz_Kristofer = degreeZ_Kristofer;

                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-poscenter.x, -poscenter.y, -poscenter.z);


                    while (tempx_Kristofer > 0) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                        tempx_Kristofer--;
                    }

                    while (tempy_Kristofer > 0) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                        tempy_Kristofer--;
                    }

                    while (tempz_Kristofer > 0) {
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

                    while (tempx_Kristofer < degreeX_Kristofer) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                        tempx_Kristofer++;
                    }

                    while (tempy_Kristofer < degreeY_Kristofer) {
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                        objectsMakiDragon_Kristofer.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                        tempy_Kristofer++;
                    }

                    while (tempz_Kristofer < degreeZ_Kristofer) {
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
        if (window.isKeyPressed(GLFW_KEY_K)) {
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

            if (!sayapatas_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                curdegree_Kristofer += 1;
                System.out.println("atas");
//                objectsDragon.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(pos1.x,pos1.y,pos1.z));
//                objectsDragon.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(pos2.x,pos2.y,pos2.z));
            }
            if (!sayapbawah_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(8).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, -1.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(9).rotateObject(Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                curdegree_Kristofer -= 1;
                System.out.println("bawah");
//                objectsDragon.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(pos1.x,pos1.y,pos1.z));
//                objectsDragon.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(pos2.x,pos2.y,pos2.z));
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
        if (window.isKeyPressed(GLFW_KEY_I)) {
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

            while (tempx_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0) {
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

            if (kaki_kiri_Kristofer) {
                if (counter_kiri_Kristofer < 15 && kaki_kiri_atas_Kristofer) {
                    counter_kiri_Kristofer += 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                } else if (counter_kiri_Kristofer == 15 && kaki_kiri_atas_Kristofer) {
                    kaki_kiri_atas_Kristofer = false;
                } else if (counter_kiri_Kristofer == 0 && !kaki_kiri_atas_Kristofer) {
                    kaki_kiri_atas_Kristofer = true;
                    kaki_kiri_Kristofer = false;
                    kaki_kanan_Kristofer = true;
                } else {
                    counter_kiri_Kristofer -= 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
            } else if (kaki_kanan_Kristofer) {
                if (counter_kanan_Kristofer < 15 && kaki_kanan_atas_Kristofer) {
                    counter_kanan_Kristofer += 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                } else if (counter_kanan_Kristofer == 15 && kaki_kanan_atas_Kristofer) {
                    kaki_kanan_atas_Kristofer = false;
                } else if (counter_kanan_Kristofer == 0 && !kaki_kanan_atas_Kristofer) {
                    kaki_kanan_atas_Kristofer = true;
                    kaki_kanan_Kristofer = false;
                    kaki_kiri_Kristofer = true;
                } else {
                    counter_kanan_Kristofer -= 1;
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

            while (tempx_Kristofer < degreeX_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer) {
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

    public void fly_MakiDragon_Kristofer() {
        if (terbang_Kristofer) {
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
        } else {
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

            while (tempx_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                tempx_Kristofer--;
            }

            while (tempy_Kristofer > 0) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                tempy_Kristofer--;
            }

            while (tempz_Kristofer > 0) {
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

            if (kaki_kiri_Kristofer) {
                if (counter_kiri_Kristofer < 15 && kaki_kiri_atas_Kristofer) {
                    counter_kiri_Kristofer += 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, -1.0f);
                } else if (counter_kiri_Kristofer == 15 && kaki_kiri_atas_Kristofer) {
                    kaki_kiri_atas_Kristofer = false;
                } else if (counter_kiri_Kristofer == 0 && !kaki_kiri_atas_Kristofer) {
                    kaki_kiri_atas_Kristofer = true;
                    kaki_kiri_Kristofer = false;
                    kaki_kanan_Kristofer = true;
                } else {
                    counter_kiri_Kristofer -= 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                }
            } else if (kaki_kanan_Kristofer) {
                if (counter_kanan_Kristofer < 15 && kaki_kanan_atas_Kristofer) {
                    counter_kanan_Kristofer += 1;
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                    objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(Math.toRadians(1), 0.0f, 0.0f, 1.0f);
                } else if (counter_kanan_Kristofer == 15 && kaki_kanan_atas_Kristofer) {
                    kaki_kanan_atas_Kristofer = false;
                } else if (counter_kanan_Kristofer == 0 && !kaki_kanan_atas_Kristofer) {
                    kaki_kanan_atas_Kristofer = true;
                    kaki_kanan_Kristofer = false;
                    kaki_kiri_Kristofer = true;
                } else {
                    counter_kanan_Kristofer -= 1;
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

            while (tempx_Kristofer < degreeX_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);

                tempx_Kristofer++;
            }

            while (tempy_Kristofer < degreeY_Kristofer) {
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectsMakiDragon_Kristofer.get(0).getChildObject().get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);

                tempy_Kristofer++;
            }

            while (tempz_Kristofer < degreeZ_Kristofer) {
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

    public void inputBlockDragon() {
        if (window.isKeyPressed(GLFW_KEY_7) &&
                (!window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_S) && !window.isKeyPressed(GLFW_KEY_D))) {
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            if (blockDegreeY > 359) {
                blockDegreeY = 0;
            }
            if (blockDegreeY < 0) {
                blockDegreeY = 359;
            }
            if (blockDegreeY != 270) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                if (blockDegreeY > 90 && blockDegreeY <= 270) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    }
                    blockDegreeY++;
                } else {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    }
                    blockDegreeY--;
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_6) &&
                (!window.isKeyPressed(GLFW_KEY_A) && !window.isKeyPressed(GLFW_KEY_S) && !window.isKeyPressed(GLFW_KEY_D))) {
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            if (blockDegreeY > 359) {
                blockDegreeY = 0;
            }
            if (blockDegreeY < 0) {
                blockDegreeY = 359;
            }
            if (blockDegreeY != 180) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                if (blockDegreeY > 0 && blockDegreeY <= 180) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    }
                    blockDegreeY++;
                } else {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    }
                    blockDegreeY--;
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_8) &&
                (!window.isKeyPressed(GLFW_KEY_A) && !window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_D))) {
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            if (blockDegreeY > 359) {
                blockDegreeY = 0;
            }
            if (blockDegreeY < 0) {
                blockDegreeY = 359;
            }
            if (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                if (blockDegreeY > 180) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    }
                    blockDegreeY++;
                } else {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    }
                    blockDegreeY--;
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_9) &&
                (!window.isKeyPressed(GLFW_KEY_A) && !window.isKeyPressed(GLFW_KEY_W) && !window.isKeyPressed(GLFW_KEY_S))) {
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            if (blockDegreeY > 359) {
                blockDegreeY = 0;
            }
            if (blockDegreeY < 0) {
                blockDegreeY = 359;
            }
            if (blockDegreeY != 90) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                if (blockDegreeY <= 90 || blockDegreeY >= 270) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                    }
                    blockDegreeY++;
                } else {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                    }
                    blockDegreeY--;
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            if (blockDegreeY > 359) {
                blockDegreeY = 0;
            }
            blockDegreeY++;
            for (ObjectBlockDragon object : blockDragon) {
                object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            if (blockDegreeX > 359) {
                blockDegreeX = 0;
            }
            blockDegreeX++;
            for (ObjectBlockDragon object : blockDragon) {
                object.rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

        }

        if (window.isKeyPressed(GLFW_KEY_B) && !blockHandToggle) {
            blockHandToggle = true;
        }

        if (window.isKeyPressed(GLFW_KEY_N) && blockHandToggle) {
            blockHandToggle = false;
        }


        if (blockHandToggle) {
            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            if (blockHandZ > 359) {
                blockHandZ = 0;
            } else if (blockHandZ < 0) {
                blockHandZ = 359;
            }

            if (blockHandZ == 25) {
                blockHandMin = true;
                blockHandMax = false;
            }

            if (blockHandZ == 330) {
                blockHandMax = true;
                blockHandMin = false;
            }

            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            Vector3f pos1 = anchorPoint.get(4).model.transformPosition(new Vector3f());
            Vector3f pos2 = anchorPoint.get(5).model.transformPosition(new Vector3f());

            int tempX = blockDegreeX;
            int tempY = blockDegreeY;
            int tempZ = blockDegreeZ;


            blockDragon.get(4).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(5).translateObject(-pos.x, -pos.y, -pos.z);
            while (blockDegreeX < 0) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                blockDegreeX--;
            }

            while (blockDegreeY > 0) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                blockDegreeY--;
            }

            while (blockDegreeZ > 0) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockDegreeZ--;
            }

            blockDragon.get(4).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(5).translateObject(pos.x, pos.y, pos.z);

            blockDragon.get(4).translateObject(-pos1.x, -pos1.y, -pos1.z);
            blockDragon.get(5).translateObject(-pos2.x, -pos2.y, -pos2.z);

            if (!blockHandMin) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockHandZ++;
            } else if (!blockHandMax) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockHandZ--;
            }

            blockDragon.get(4).translateObject(pos1.x, pos1.y, pos1.z);
            blockDragon.get(5).translateObject(pos2.x, pos2.y, pos2.z);


            blockDragon.get(4).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(5).translateObject(-pos.x, -pos.y, -pos.z);
            while (blockDegreeX < tempX) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                blockDegreeX++;
            }

            while (blockDegreeY < tempY) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                blockDegreeY++;
            }

            while (blockDegreeZ < tempZ) {
                blockDragon.get(4).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockDragon.get(5).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockDegreeZ++;
            }

            blockDragon.get(4).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(5).translateObject(pos.x, pos.y, pos.z);

            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }
        }

        if (blockHeight > 0) {

            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            if (blockWingY == 20) {
                blockWingMax = true;
                blockWingMin = false;
            }

            if (blockWingY == 0) {
                blockWingMin = true;
                blockWingMax = false;
            }

            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            Vector3f pos1 = anchorPoint.get(6).model.transformPosition(new Vector3f());
            Vector3f pos2 = anchorPoint.get(7).model.transformPosition(new Vector3f());


            int tempX = blockDegreeX;
            int tempY = blockDegreeY;
            int tempZ = blockDegreeZ;

            blockDragon.get(6).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(7).translateObject(-pos.x, -pos.y, -pos.z);

            while (blockDegreeX < 0) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                blockDegreeX--;
            }

            while (blockDegreeY > 0) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                blockDegreeY--;
            }

            while (blockDegreeZ > 0) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                blockDegreeZ--;
            }

            blockDragon.get(6).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(7).translateObject(pos.x, pos.y, pos.z);


            blockDragon.get(6).translateObject(-pos1.x, -pos1.y, -pos1.z);
            blockDragon.get(7).translateObject(-pos2.x, -pos2.y, -pos2.z);
            if (blockWingMin) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(2.0f)), 0.0f, 1.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(2.0f)), 0.0f, -1.0f, 0.0f);
                blockWingY++;
            } else if (blockWingMax) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(2.0f)), 0.0f, -1.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(2.0f)), 0.0f, 1.0f, 0.0f);
                blockWingY--;
            }
            blockDragon.get(6).translateObject(pos1.x, pos1.y, pos1.z);
            blockDragon.get(7).translateObject(pos2.x, pos2.y, pos2.z);

            blockDragon.get(6).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(7).translateObject(-pos.x, -pos.y, -pos.z);
            while (blockDegreeX < tempX) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                blockDegreeX++;
            }

            while (blockDegreeY < tempY) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                blockDegreeY++;
            }

            while (blockDegreeZ < tempZ) {
                blockDragon.get(6).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockDragon.get(7).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                blockDegreeZ++;
            }
            blockDragon.get(6).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(7).translateObject(pos.x, pos.y, pos.z);


            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }
        }

        if (window.isKeyPressed(GLFW_KEY_M) && blockHeight == 0) {
            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            int tempY = blockDegreeY;
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }

            while (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                blockDegreeY--;
            }

            while (blockDegreeX != 30) {
                if (blockDegreeX > 30) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                    }
                    blockDegreeX--;
                } else {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                    }
                    blockDegreeX++;
                }
            }

            while (blockDegreeY != tempY) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                blockDegreeY++;
            }

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(0.0f, 0.25f, 0.0f);
            }

            for (ObjectBlockDragon object : anchorPoint) {
                object.translateObject(0.0f, 0.25f, 0.0f);
            }
            blockHeight++;

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K) && blockHeight == 1) {
            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            int tempY = blockDegreeY;
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }

            while (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                blockDegreeY--;
            }


            while (blockDegreeX != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                }
                blockDegreeX--;
            }

            while (blockDegreeY != tempY) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                blockDegreeY++;
            }

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(0.0f, -0.25f, 0.0f);
            }

            for (ObjectBlockDragon object : anchorPoint) {
                object.translateObject(0.0f, -0.25f, 0.0f);
            }
            blockHeight--;

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }
        }

        if (window.isKeyPressed(GLFW_KEY_H)) {

            int tempY = blockDegreeY;
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());


            while (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
                blockDegreeY--;
            }

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(0.0f, 0.0f, 0.01f);
            }
            for (ObjectBlockDragon object2 : anchorPoint) {
                object2.translateObject(0.0f, 0.0f, 0.01f);
            }

            blockX = (int) (anchorPoint.get(0).model.transformPosition(new Vector3f()).x * 100);
            blockY = (int) (anchorPoint.get(0).model.transformPosition(new Vector3f()).y * 100);
            blockZ = (int) (anchorPoint.get(0).model.transformPosition(new Vector3f()).z * 10);


            while (blockDegreeY != tempY) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                for (ObjectBlockDragon object : anchorPoint) {
                    object.translateObject(-pos.x, -pos.y, -pos.z);
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                for (ObjectBlockDragon object : anchorPoint) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
                for (ObjectBlockDragon object : anchorPoint) {
                    object.translateObject(pos.x, pos.y, pos.z);
                }
                blockDegreeY++;
            }

            pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            for (ObjectBlockDragon object : anchorPoint) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }
            while (tempY != 0) {
                for (ObjectBlockDragon object : anchorPoint) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                tempY--;
            }
            for (ObjectBlockDragon object : anchorPoint) {
                object.translateObject(pos.x, pos.y, pos.z);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_B)) {

            if (big) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.scaleObject(1.1f, 1.1f, 1.1f);
                }
                for (ObjectBlockDragon object : anchorPoint) {
                    object.scaleObject(1.1f, 1.1f, 1.1f);
                }
                bigCount++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (ObjectBlockDragon object : blockDragon) {
                    object.scaleObject(0.91f, 0.91f, 0.91f);
                }
                for (ObjectBlockDragon object : anchorPoint) {
                    object.scaleObject(0.91f, 0.91f, 0.91f);
                }
                bigCount--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (bigCount > 0) {
                big = false;
            } else if (bigCount == 0) {
                big = true;
            }

        }

        if (window.isKeyPressed(GLFW_KEY_P) && !blockSit) {
            blockSit = true;
            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            int tempY = blockDegreeY;
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }
            while (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                blockDegreeY--;
            }
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            for (int i = 0; i < 3; i++) {
                blockDragon.get(8).scaleObject(2.0f, 2.0f, 2.0f);
            }

            for (int i = 0; i < 3; i++) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(0.0f, 0.05f, 0.0f);
                }
                blockDragon.get(8).translateObject(0.0f, -0.05f, 0.0f);
            }
            for (int i = 0; i < 3; i++) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(0.0f, 0.05f, 0.0f);
                }
                blockDragon.get(8).translateObject(0.0f, -0.05f, 0.0f);
            }


            pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            blockDragon.get(2).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(3).translateObject(-pos.x, -pos.y, -pos.z);
            for (int i = 0; i < 90; i++) {
                blockDragon.get(2).rotateObject((float) (Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
                blockDragon.get(3).rotateObject((float) (Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
            }
            blockDragon.get(2).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(3).translateObject(pos.x, pos.y, pos.z);

            blockDragon.get(2).translateObject(0.0f, 0.3f, 0.37f);
            blockDragon.get(3).translateObject(0.0f, 0.3f, 0.37f);

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(0.0f, -0.15f, 0.0f);
            }
            blockDragon.get(8).translateObject(0.0f, 0.15f, 0.0f);

            pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }
            while (blockDegreeY != tempY) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                blockDegreeY++;
            }
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }


        }

        if (window.isKeyPressed(GLFW_KEY_F) && blockSit) {
            blockDragon.get(8).translateObject((float) blockX * 0.65f, (float) blockY, (float) blockZ * 0.65f);
            blockSit = false;
            int tempBlockX = blockX;
            int tempBlockY = blockY;
            int tempBlockZ = blockZ;

            if (blockX <= 0) {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            } else {
                while (blockX != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            }

            if (blockY <= 0) {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            } else {
                while (blockY != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            }

            if (blockZ <= 0) {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            } else {
                while (blockZ != 0) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            }

            int tempY = blockDegreeY;
            Vector3f pos = anchorPoint.get(0).model.transformPosition(new Vector3f());

            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }
            while (blockDegreeY != 0) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
                }
                blockDegreeY--;
            }
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            blockDragon.get(8).translateObject(0.0f, -0.15f, 0.0f);
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(0.0f, 0.15f, 0.0f);
            }
            blockDragon.get(2).translateObject(0.0f, -0.3f, -0.37f);
            blockDragon.get(3).translateObject(0.0f, -0.3f, -0.37f);

            pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            blockDragon.get(2).translateObject(-pos.x, -pos.y, -pos.z);
            blockDragon.get(3).translateObject(-pos.x, -pos.y, -pos.z);
            for (int i = 0; i < 90; i++) {
                blockDragon.get(2).rotateObject((float) (Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                blockDragon.get(3).rotateObject((float) (Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            blockDragon.get(2).translateObject(pos.x, pos.y, pos.z);
            blockDragon.get(3).translateObject(pos.x, pos.y, pos.z);

            for (int i = 0; i < 3; i++) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(0.0f, -0.05f, 0.0f);
                }
                blockDragon.get(8).translateObject(0.0f, 0.05f, 0.0f);
            }

            for (int i = 0; i < 3; i++) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.translateObject(0.0f, -0.05f, 0.0f);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 3; i++) {
                blockDragon.get(8).scaleObject(0.5f, 0.5f, 0.5f);
            }
            blockDragon.get(8).translateObject(0.0f, 0.01875f, 0.0f);

            pos = anchorPoint.get(0).model.transformPosition(new Vector3f());
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(-pos.x, -pos.y, -pos.z);
            }
            while (blockDegreeY != tempY) {
                for (ObjectBlockDragon object : blockDragon) {
                    object.rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                }
                blockDegreeY++;
            }
            for (ObjectBlockDragon object : blockDragon) {
                object.translateObject(pos.x, pos.y, pos.z);
            }

            if (tempBlockX <= 0) {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(-0.01f, 0.0f, 0.0f);
                    }
                    blockX--;
                }
            } else {
                while (blockX != tempBlockX) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.01f, 0.0f, 0.0f);
                    }
                    blockX++;
                }
            }
            if (tempBlockY <= 0) {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, -0.01f, 0.0f);
                    }
                    blockY--;
                }
            } else {
                while (blockY != tempBlockY) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.01f, 0.0f);
                    }
                    blockY++;
                }
            }

            if (tempBlockZ <= 0) {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, -0.01f);
                    }
                    blockZ--;
                }
            } else {
                while (blockZ != tempBlockZ) {
                    for (ObjectBlockDragon object : blockDragon) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    for (ObjectBlockDragon object : anchorPoint) {
                        object.translateObject(0.0f, 0.0f, 0.01f);
                    }
                    blockZ++;
                }
            }
        }
    }

    public void input_IceCubeD() {
        //tangan gerak Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_F)) {
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 5) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(24).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(25).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(1).translateObject(-pos2.x, -pos2.y, pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(1).translateObject(pos2.x, pos2.y, -pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }

        }
        //Sayap Gerak Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_K)) {
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 10) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(28).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(29).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(-pos1.x, -pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(-pos2.x, -pos2.y, pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(pos1.x, pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(pos2.x, pos2.y, -pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
        }
//        if (window.isKeyPressed(GLFW_KEY_K)){
////            objects.get(0).getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        }

        //rotate kiri Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_E)) {
            objectIceCubeDS.get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
        }
        //rotate atas Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_H)) {
            objectIceCubeDS.get(0).rotateObject((float) Math.toRadians(1.0f), -1.0f, 0.0f, 0.0f);

//            for(Object child: objects.get(0).getChildObject()){
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//                child.translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
//                child.rotateObject((float) Math.toRadians(1.0f),-1.0f,0.0f,0.0f);
//                child.translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
//            }
//            for(Object child: objects.get(0).getChildObject().get(1).getChildObject()){
//                Vector3f tempCenterPoint = objects.get(0).getChildObject().get(1).updateCenterPoint();
//                child.translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
//                child.rotateObject((float) Math.toRadians(0.7f),0.0f,0.0f,1.0f);
//                child.translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
//            }
        }
        //rotate kanan Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            objectIceCubeDS.get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, -1.0f, 0.0f);
        }
        //rotate bawah Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_J)) {
            objectIceCubeDS.get(0).rotateObject((float) Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);
        }

//        if (window.isKeyPressed(GLFW_KEY_F)){
//            while (degX < 0){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), -1.0f, 0.0f, 0.0f);
//                degX--;
//            }
//
//            while (degY > 0){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, -1.0f, 0.0f);
//                degY--;
//            }
//
//            while (degZ > 0){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, -1.0f);
//                degZ--;
//            }
//            while (degX < tempX){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
//                degX++;
//            }
//
//            while (degY < tempY){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
//                degY++;
//            }
//
//            while (degZ < tempZ){
//                objects.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
//                objects.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
//                degZ++;
//            }
//        }
        //dot lepas
        if (window.isKeyPressed(GLFW_KEY_U)) {
            float temp = 0.01f;
            Vector3f pos = objectIceCubeDS.get(0).getChildObject().get(19).model.transformPosition(new Vector3f());
            objectIceCubeDS.get(0).getChildObject().get(20).translateObject(-pos.x, -pos.y, pos.z);
            objectIceCubeDS.get(0).getChildObject().get(20).translateObject(0.0f, 0.0f, temp);
            objectIceCubeDS.get(0).getChildObject().get(20).translateObject(pos.x, pos.y, -pos.z);
            tempDot = tempDot + 1;

            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 5) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(24).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(25).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(1).translateObject(-pos2.x, -pos2.y, pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(1).translateObject(pos2.x, pos2.y, -pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }

        }
        //dot kembali
        if (window.isKeyPressed(GLFW_KEY_O)) {
            float temp = 0.01f;

            if (tempDot != 0) {
                Vector3f posss = objectIceCubeDS.get(0).getChildObject().get(19).model.transformPosition(new Vector3f());
                objectIceCubeDS.get(0).getChildObject().get(20).translateObject(-posss.x, -posss.y, posss.z);
                objectIceCubeDS.get(0).getChildObject().get(20).translateObject(0.0f, 0.0f, -temp);
                objectIceCubeDS.get(0).getChildObject().get(20).translateObject(posss.x, posss.y, -posss.z);
                tempDot = tempDot - 1;
                if (rotZ > 359) {
                    rotZ = 0;
                } else if (rotZ < 0) {
                    rotZ = 359;
                }

                if (rotZ == 5) {
                    rotMin = true;
                    rotMax = false;
                }

                if (rotZ == 330) {
                    rotMax = true;
                    rotMin = false;
                }

                Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(24).model.transformPosition(new Vector3f());
                Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(25).model.transformPosition(new Vector3f());

                int rotate1 = 360 - degZ;
                int rotate2 = 360 - degY;
                int rotate3 = 360 - degX;

                for (int i = 0; i < rotate1; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                }
                for (int i = 0; i < rotate2; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                }
                for (int i = 0; i < rotate3; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                }

                objectIceCubeDS.get(0).getChildObject().get(0).translateObject(-pos1.x, -pos1.y, pos1.z);
                objectIceCubeDS.get(0).getChildObject().get(1).translateObject(-pos2.x, -pos2.y, pos2.z);

                if (!rotMin) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                    rotZ++;
                } else if (!rotMax) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                    rotZ--;
                }

                objectIceCubeDS.get(0).getChildObject().get(0).translateObject(pos1.x, pos1.y, -pos1.z);
                objectIceCubeDS.get(0).getChildObject().get(1).translateObject(pos2.x, pos2.y, -pos2.z);
                for (int i = 0; i < degX; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                }
                for (int i = 0; i < degY; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                }
                for (int i = 0; i < degZ; i++) {
                    objectIceCubeDS.get(0).getChildObject().get(0).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                    objectIceCubeDS.get(0).getChildObject().get(1).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                }
            }
        }

        //gerak ke depan sambil tangan gerak Ice Dragon
        if (window.isKeyPressed(GLFW_KEY_S)) {
            objectIceCubeDS.get(0).translateObject(0.0f, 0.0f, 0.01f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 10) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(26).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(27).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(pos1.x, -pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(pos2.x, -pos2.y, -pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(-pos1.x, pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(-pos2.x, pos2.y, pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
        }
        // gerak ke belakang dengan tangan Ice dragon
        if (window.isKeyPressed(GLFW_KEY_W)) {
            objectIceCubeDS.get(0).translateObject(0.0f, 0.0f, -0.01f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 10) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(26).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(27).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(pos1.x, -pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(pos2.x, -pos2.y, -pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(-pos1.x, pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(-pos2.x, pos2.y, pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
        }
        // gerak ke kiri dengan tangan Ice dragon
        if (window.isKeyPressed(GLFW_KEY_A)) {
            objectIceCubeDS.get(0).translateObject(-0.01f, 0.0f, 0.0f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 10) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(26).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(27).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(pos1.x, -pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(pos2.x, -pos2.y, -pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(-pos1.x, pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(-pos2.x, pos2.y, pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
        }
        // gerak ke kanan dengan tangan Ice dragon
        if (window.isKeyPressed(GLFW_KEY_D)) {
            objectIceCubeDS.get(0).translateObject(0.01f, 0.0f, 0.0f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 10) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(26).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(27).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(pos1.x, -pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(pos2.x, -pos2.y, -pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), -0.5f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.5f, 0.0f, 0.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(16).translateObject(-pos1.x, pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(17).translateObject(-pos2.x, pos2.y, pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(16).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(17).rotateObject(((float) Math.toRadians(1.0f)), 0.0f, 0.0f, 1.0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_Z)) {
            objectIceCubeDS.get(0).translateObject(0.0f, 0.01f, 0.0f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 5) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(28).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(29).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(-pos1.x, -pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(-pos2.x, -pos2.y, pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(pos1.x, pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(pos2.x, pos2.y, -pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_X)) {
            objectIceCubeDS.get(0).translateObject(0.0f, -0.01f, 0.0f);
            if (rotZ > 359) {
                rotZ = 0;
            } else if (rotZ < 0) {
                rotZ = 359;
            }

            if (rotZ == 5) {
                rotMin = true;
                rotMax = false;
            }

            if (rotZ == 330) {
                rotMax = true;
                rotMin = false;
            }

            Vector3f pos1 = objectIceCubeDS.get(0).getChildObject().get(28).model.transformPosition(new Vector3f());
            Vector3f pos2 = objectIceCubeDS.get(0).getChildObject().get(29).model.transformPosition(new Vector3f());

            int rotate1 = 360 - degZ;
            int rotate2 = 360 - degY;
            int rotate3 = 360 - degX;

            for (int i = 0; i < rotate1; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < rotate2; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < rotate3; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(-pos1.x, -pos1.y, pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(-pos2.x, -pos2.y, pos2.z);

            if (!rotMin) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                rotZ++;
            } else if (!rotMax) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, -1.0f);
                rotZ--;
            }

            objectIceCubeDS.get(0).getChildObject().get(21).translateObject(pos1.x, pos1.y, -pos1.z);
            objectIceCubeDS.get(0).getChildObject().get(22).translateObject(pos2.x, pos2.y, -pos2.z);
            for (int i = 0; i < degX; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 1.0f, 0.0f, 0.0f);
            }
            for (int i = 0; i < degY; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 1.0f, 0.0f);
            }
            for (int i = 0; i < degZ; i++) {
                objectIceCubeDS.get(0).getChildObject().get(21).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
                objectIceCubeDS.get(0).getChildObject().get(22).rotateObject(((float) Math.toRadians(1.5f)), 0.0f, 0.0f, 1.0f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_C)) {
            objectIceCubeDS.get(0).scaleObject(1.011f, 1.011f, 1.011f);
        }
        if (window.isKeyPressed(GLFW_KEY_V)) {
            objectIceCubeDS.get(0).scaleObject(0.991f, 0.991f, 0.991f);
        }


    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.7f,
                    1.0f, 1.0f,
                    0.0f);
            GL.createCapabilities();
//            input_all();
            input_IceCubeD();
            inputBlockDragon();
            input_Kris();
            input_Gummy();

            //code
            for (Object_Kristofer object : object_bg) {
                object.draw(camera_Kristofer, projection_Kristofer);
            }

            //code
//            for (Object2d_Gummy object2d : background_Gum) {
//                object2d.draw(camera_gummy, projection_gummy);
//            }
//            for (Object2d_Gummy object2d : background2) {
//                object2d.draw(camera_gummy, projection_gummy);
//            }

            for (Object2d_Gummy object2d : dragon) {
                object2d.draw(camera_gummy, projection_gummy);
            }

            //code
            for (Object_Kristofer object : anchorpoint_Kristofer) {
                object.draw(camera_Kristofer, projection_Kristofer);
            }
            for (Object_Kristofer object : object_bg) {
                object.draw(camera_Kristofer, projection_Kristofer);
            }
            for (Object_Kristofer object : objectsMakiDragon_Kristofer) {
                object.draw(camera_Kristofer, projection_Kristofer);
            }

            if (tempY_Kristofer > 0.0f) {
                terbang_Kristofer = true;
            }

            if (tempY_Kristofer <= 0.0f) {
                terbang_Kristofer = false;
            }

            fly_MakiDragon_Kristofer();

            //code
            for (Object_IceCubeD objectIceCubeD : background) {
                objectIceCubeD.draw(cameraIceCubeD, projectionIceCubeD);
            }
            for (Object_IceCubeD objectIceCubeD : objectIceCubeDS) {
                objectIceCubeD.drawWithVerticesColor();
            }
            for (Object_IceCubeD objectIceCubeD : objectsRectangle) {
                objectIceCubeD.draw(cameraIceCubeD, projectionIceCubeD);
            }
            for (Object_IceCubeD objectIceCubeD : objectIceCubeDPointsControl) {
                objectIceCubeD.drawLine();
            }
            for (Object_IceCubeD objectIceCubeD : objectIceCubeDS) {
                objectIceCubeD.draw(cameraIceCubeD, projectionIceCubeD);
            }

            //code

//            for(ObjectBlockDragon object: background){
//                object.draw(camera, projection);
//            }

            for (ObjectBlockDragon object : blockDragon) {
                object.draw(camera, projection);
            }
            blockDragon.get(8).draw(camera, projection);

            for (ObjectBlockDragon object : anchorPoint) {
                object.draw(camera, projection);
            }


            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {
//        init_Gummy();
//        initBlockDragon();
//        blockinit();
//        init_Kris();
//        init_IceCubeD();
        init_all();


        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main_All().run();
    }
}