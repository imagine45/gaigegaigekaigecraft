package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletDomainHitProcedure {
   public BulletDomainHitProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean logic_a = false;
         double range = 0.0;
         double dis = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed") && entity instanceof LivingEntity) {
               immediatesourceentity.getPersistentData().m_128347_("cnt_bullet_hit", immediatesourceentity.getPersistentData().m_128459_("cnt_bullet_hit") + 1.0);
               if (immediatesourceentity.getPersistentData().m_128459_("cnt_bullet_hit") > 1.0) {
                  double var10000;
                  int var10001;
                  label44: {
                     immediatesourceentity.getPersistentData().m_128347_("cnt_bullet_hit", -15.0);
                     var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                           break label44;
                        }
                     }

                     var10001 = 0;
                  }

                  range = var10000 * (double)(var10001 > 0 ? 6 : 2);
                  Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                        immediatesourceentity.m_6021_((double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_() - (immediatesourceentity.m_20184_().m_7096_() + Math.random() - 0.5), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_() - (immediatesourceentity.m_20184_().m_7098_() + Math.random() - 0.5), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_() - (immediatesourceentity.m_20184_().m_7094_() + Math.random() - 0.5));
                        if (immediatesourceentity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)immediatesourceentity;
                           _serverPlayer.f_8906_.m_9774_((double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_() - (immediatesourceentity.m_20184_().m_7096_() + Math.random() - 0.5), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_() - (immediatesourceentity.m_20184_().m_7098_() + Math.random() - 0.5), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_() - (immediatesourceentity.m_20184_().m_7094_() + Math.random() - 0.5), immediatesourceentity.m_146908_(), immediatesourceentity.m_146909_());
                        }

                        immediatesourceentity.m_7618_(Anchor.EYES, new Vec3((double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_(), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_(), (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_()));
                        break;
                     }
                  }
               }
            }
         }

      }
   }
}
