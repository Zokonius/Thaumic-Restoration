package com.Zoko061602.ThaumicRestoration.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelInfuser extends ModelBase {

	final ModelRenderer top;
    final ModelRenderer pillar;
    final ModelRenderer base;

	public ModelInfuser() {
		textureWidth = 64;
		textureHeight = 64;

		base = new ModelRenderer(this, 0, 0);
		base.setRotationPoint(0, 16, 0);
		base.addBox(-8, -16, -8, 16, 4, 16, 0);

		pillar = new ModelRenderer(this, 0, 20);
		pillar.setRotationPoint(0, 16, 0);
		pillar.addBox(-4, -12, -4, 8, 8, 8, 0);

		top = new ModelRenderer(this, 0, 36);
		top.setRotationPoint(0, 16, 0);
		top.addBox(-6, -4, -6, 12, 4, 12, 0);

	}

	public void render() {
		float f = 1F/16F;
		top.render(f);
		pillar.render(f);
		base.render(f);

	}



}
