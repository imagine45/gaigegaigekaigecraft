package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.BlackHoleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PureLoveCannonEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DespawnRangedAmmoProcedure {
   public DespawnRangedAmmoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && (entity.getPersistentData().m_128459_("NameRanged") != 0.0 && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") || entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_()))) {
               logic_a = true;
               if (entityiterator instanceof PurpleEntity || entityiterator instanceof UzumakiEntity || entityiterator instanceof PureLoveCannonEntity || entityiterator instanceof MeteorEntity || entityiterator instanceof BlackHoleEntity) {
                  logic_a = false;
               }

               if (!ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.m_6095_()).toString().contains("jujutsucraft:")) {
                  logic_a = false;
               }

               if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_cursed_technique")))) {
                  logic_a = false;
               }

               if (logic_a && !entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
            }
         }

      }
   }
}
