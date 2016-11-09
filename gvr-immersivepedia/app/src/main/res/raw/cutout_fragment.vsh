#version 300 es
precision mediump float;
in vec2  coord;
uniform sampler2D u_texture;

layout (std140) uniform Material_ubo{
    vec4 cutout;
};

out vec4 outColor;

void main() {

	vec4 color;	
	color = texture(u_texture, coord);
	
	if(color.r < cutout.x){
		outColor = vec4(0,0,0,color.a);
	}else{
		outColor = vec4(0,0,0,0);
	}
	if(color.a < 1.0)
		outColor = vec4(0,0,0,0);
}