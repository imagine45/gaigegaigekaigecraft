package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DespawnTenShadowsTechniqueProcedure {
   public DespawnTenShadowsTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double NUM_SUM = 0.0;
         double NUM_SUM_TRUE = 0.0;
         if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
            if (entity.getPersistentData().m_128459_("skill") != 0.0) {
               if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt4", 1.0);
               }

               if (entity instanceof RozetsuShikigamiVessel2Entity) {
                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") - 8.0);
               }

               NUM_SUM = entity.getPersistentData().m_128459_("cnt4");
            }

            NUM_SUM_TRUE = NUM_SUM;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().m_128471_("domain_entity") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") && entityiterator.getPersistentData().m_128471_("Ambush")) {
                  if (entity instanceof FushiguroMegumiEntity && entityiterator instanceof MaxElephantEntity) {
                     NUM1 = 2.0;
                  } else if (entityiterator instanceof RabbitEscapeEntity) {
                     NUM1 = 0.025;
                  } else {
                     NUM1 = 1.0;
                  }

                  if (NUM_SUM + NUM1 > 2.0 && entity.getPersistentData().m_128459_("skill") != 0.0) {
                     entityiterator.getPersistentData().m_128379_("flag_despawn", true);
                  } else {
                     NUM_SUM_TRUE += NUM1;
                  }

                  NUM_SUM += NUM1;
               }
            }
         }

         entity.getPersistentData().m_128347_("cnt4", 0.0);
         if (!(entity instanceof Player)) {
            if (NUM_SUM_TRUE > 2.0) {
               entity.getPersistentData().m_128347_("NUM_TenShadowsTechnique", 0.0);
            } else {
               entity.getPersistentData().m_128347_("NUM_TenShadowsTechnique", NUM_SUM_TRUE);
            }
         }

      }
   }
}
