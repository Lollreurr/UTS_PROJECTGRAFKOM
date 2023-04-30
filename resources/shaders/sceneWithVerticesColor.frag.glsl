#version 330
//uniform vec4 uni_color;
out vec4 fragColor;
in vec4 out_color;
void main()
{
    //vec4(red,green,blue,alpha)
    //rgba -> red 100/255
//    fragColor = vec4(1.0,0.0,0.0,1.0);
    fragColor = out_color;
}