package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.HeadJetItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HeadJetModel extends GeoModel<HeadJetItem> {
   public HeadJetModel() {
   }

   public ResourceLocation getAnimationResource(HeadJetItem object) {
      return new ResourceLocation("jujutsucraft", "animations/head_jet.animation.json");
   }

   public ResourceLocation getModelResource(HeadJetItem object) {
      return new ResourceLocation("jujutsucraft", "geo/head_jet.geo.json");
   }

   public ResourceLocation getTextureResource(HeadJetItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/head_jets.png");
   }
}
