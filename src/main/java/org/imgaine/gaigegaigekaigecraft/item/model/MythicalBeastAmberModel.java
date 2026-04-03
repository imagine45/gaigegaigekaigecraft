package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.MythicalBeastAmberItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MythicalBeastAmberModel extends GeoModel<MythicalBeastAmberItem> {
   public MythicalBeastAmberModel() {
   }

   public ResourceLocation getAnimationResource(MythicalBeastAmberItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/mythicalbeastamber_head.animation.json");
   }

   public ResourceLocation getModelResource(MythicalBeastAmberItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/mythicalbeastamber_head.geo.json");
   }

   public ResourceLocation getTextureResource(MythicalBeastAmberItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/mythical_beast_amber_head.png");
   }
}
