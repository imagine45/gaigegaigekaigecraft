package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackNueProcedure {
   public AttackNueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double entity_size = 0.0;
         Entity entity_a = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity instanceof NueEntity) {
               ((NueEntity)entity).setAnimation("tackle");
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var67 = ((Entity)var10000).m_20186_();
               LivingEntity var69;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var69 = _mobEnt.m_5448_();
               } else {
                  var69 = null;
               }

               y_pos = var67 + (double)((Entity)var69).m_20206_() * 0.5;
               LivingEntity var68;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var68 = _mobEnt.m_5448_();
               } else {
                  var68 = null;
               }

               z_pos = ((Entity)var68).m_20189_();
            } else {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = (double)(64.0F + entity.m_20205_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!(entity instanceof Player)) {
                  rotate = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(24.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (!rotate && entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        rotate = true;
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                        z_pos = entityiterator.m_20189_();
                     }
                  }

                  if (!rotate && entity.getPersistentData().m_128459_("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        dis = GetDistanceIteratorProcedure.execute(entity, entity_a);
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           x_pos = ((Entity)var10000).m_20185_();
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           double var63 = ((Entity)var10000).m_20186_();
                           LivingEntity var10001;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10001 = _mobEnt.m_5448_();
                           } else {
                              var10001 = null;
                           }

                           y_pos = var63 + (double)((Entity)var10001).m_20206_() * 0.5;
                           LivingEntity var64;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var64 = _mobEnt.m_5448_();
                           } else {
                              var64 = null;
                           }

                           z_pos = ((Entity)var64).m_20189_();
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().m_128379_("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < 30.0) {
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75, entity.getPersistentData().m_128459_("z_power") * 0.75));
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), 0.4 * (double)entity.m_20205_(), 0.4 * (double)entity.m_20206_(), 0.4 * (double)entity.m_20205_(), 0.1);
         }

         RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * 100.0, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * 100.0, entity.m_20189_() + entity.m_20184_().m_7094_() * 100.0, entity);
         entity.getPersistentData().m_128347_("Damage", 12.0);
         entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20206_()));
         entity.getPersistentData().m_128347_("knockback", 0.5 + Math.random());
         entity.getPersistentData().m_128347_("effect", 9.0);
         entity.getPersistentData().m_128379_("swing", true);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > 40.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
