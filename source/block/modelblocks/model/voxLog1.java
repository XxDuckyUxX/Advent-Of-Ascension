package net.nevermine.block.modelblocks.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.nevermine.block.modelblocks.ModelEternalBlock;

public class voxLog1 extends ModelBase implements ModelEternalBlock {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;

	public voxLog1() {
		textureWidth = 128;
		textureHeight = 64;
		(Shape1 = new ModelRenderer(this, 41, 19)).addBox(15.0f, 0.0f, 0.0f, 2, 12, 16);
		Shape1.setRotationPoint(-9.0f, 10.0f, -8.0f);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0.0f, 0.0f, 0.0f);
		(Shape2 = new ModelRenderer(this, 64, 0)).addBox(0.0f, -1.0f, 0.0f, 16, 2, 16);
		Shape2.setRotationPoint(-8.0f, 23.0f, -8.0f);
		Shape2.setTextureSize(128, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0.0f, 0.0f, 0.0f);
		(Shape3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 2, 16);
		Shape3.setRotationPoint(-8.0f, 8.0f, -8.0f);
		Shape3.setTextureSize(128, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0.0f, 0.0f, 0.0f);
		(Shape4 = new ModelRenderer(this, 0, 19)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 16);
		Shape4.setRotationPoint(-8.0f, 10.0f, -8.0f);
		Shape4.setTextureSize(128, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0.0f, 0.0f, 0.0f);
	}

	public void render(final float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
	}

	private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}