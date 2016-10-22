/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gearvrf.immersivepedia.shader;

import android.content.Context;

import org.gearvrf.GVRContext;
//import org.gearvrf.GVRCustomMaterialShaderId;
import org.gearvrf.GVRMaterialMap;
import org.gearvrf.GVRMaterialShaderManager;
import org.gearvrf.GVRShader;
import org.gearvrf.GVRShaderData;
import org.gearvrf.immersivepedia.R;
import org.gearvrf.utility.TextFile;

public class CutoutShader extends GVRShader{

    public static final String TEXTURE_KEY = "texture";
    public static final String CUTOUT = "cutout";

    //private GVRCustomMaterialShaderId mShaderId;
    private GVRMaterialMap mCustomShader = null;

    public CutoutShader(GVRContext gvrContext) {
        /*
        final GVRMaterialShaderManager shaderManager = gvrContext.getMaterialShaderManager();
        mShaderId = shaderManager.addShader(R.raw.cutout_vertex, R.raw.cutout_fragment);
        mCustomShader = shaderManager.getShaderMap(mShaderId);
        mCustomShader.addTextureKey("texture", TEXTURE_KEY);
        mCustomShader.addUniformFloatKey("cutout", CUTOUT);*/
        super("float cutout", "sampler2D texture", "float4 a_position, float3 a_normal, float2 a_tex_coord");

        Context context = gvrContext.getContext();
        setSegment("FragmentTemplate", TextFile.readTextFile(context, R.raw.cutout_fragment));
        setSegment("VertexTemplate", TextFile.readTextFile(context,R.raw.cutout_vertex));

    }

    protected void setMaterialDefaults(GVRShaderData material)
    {
        material.setFloat("cutout", 1);
    }
}
