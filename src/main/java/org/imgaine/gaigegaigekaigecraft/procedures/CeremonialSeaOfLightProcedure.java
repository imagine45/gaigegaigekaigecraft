package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class CeremonialSeaOfLightProcedure {
   public CeremonialSeaOfLightProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = 0.0;
         double z_center = 0.0;
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num3 = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().m_128347_("select", 14.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > 0.0) {
            dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            x_center = entity.getPersistentData().m_128459_("x_pos_doma");
            y_center = entity.getPersistentData().m_128459_("y_pos_doma");
            z_center = entity.getPersistentData().m_128459_("z_pos_doma");
            y_pos = y_center;
            if (entity.getPersistentData().m_128459_("cnt1") <= JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
               num1 = Math.toRadians(Math.random() * 720.0);
               num2 = entity.getPersistentData().m_128459_("cnt1") / 2.0;
               num3 = Math.toRadians(8.0);

               for(int index0 = 0; index0 < 90; ++index0) {
                  x_pos = x_center + Math.sin(num1) * num2;
                  z_pos = z_center + Math.cos(num1) * num2;
                  if (Math.random() < 0.25 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), x_pos, y_pos, z_pos, 1, 0.25, Math.max(num2 / 10.0, 0.25), 0.25, 0.05);
                  }

                  num1 += Math.random() * num3;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 34.0) {
               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - 6.0);
                  z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - 6.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TREE_HANAMI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

                        entityinstance.m_146922_((float)(Math.random() * 360.0));
                        entityinstance.m_146926_(0.0F);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  yaw += 45.0;
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
