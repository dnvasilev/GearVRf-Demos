#version 300 es
precision mediump float;
in vec2  coord;
uniform sampler2D state1;
uniform sampler2D state2;

layout (std140) uniform Material_ubo{
    vec4 textureSwitch;
    vec4 u_opacity;
};

out vec4 outColor;

void main() {
	vec4 textureColor;
	if(textureSwitch.x == 0.0) {
		textureColor = texture(state1, coord);
	} else {
		textureColor = texture(state2, coord);
	}
		
	outColor = textureColor;
	outColor.a = outColor.a * u_opacity.x;
}