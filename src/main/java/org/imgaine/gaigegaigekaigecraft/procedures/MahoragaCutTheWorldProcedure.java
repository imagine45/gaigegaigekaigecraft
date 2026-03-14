package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MahoragaCutTheWorldProcedure {
   public MahoragaCutTheWorldProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean worldCutter = false;
         boolean mahoraga_exist = false;
         boolean canUseWorld = false;
         Entity entity_owner = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002 = new Vec3;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            double var71 = ((Entity)var10004).m_20185_();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.m_5448_();
            } else {
               var10005 = null;
            }

            double var72 = ((Entity)var10005).m_20186_();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var72 += (double)((Entity)var10006).m_20206_() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var10002.<init>(var71, var72, ((Entity)var10006).m_20189_());
            entity.m_7618_(var10001, var10002);
         }

         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity16 = (LivingEntity)entity;
               if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity16.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity17 = (LivingEntity)entity;
               if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity17.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") == 5.0) {
            worldCutter = true;
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F, false);
               }
            }

            entity.getPersistentData().m_128347_("cnt2", Math.random() * 4.0 - 2.0);
            entity.getPersistentData().m_128347_("cnt3", Math.abs(entity.getPersistentData().m_128459_("cnt2")) - 2.0);
            range = 2.0;
            yaw2 = yaw - entity.getPersistentData().m_128459_("cnt2") * 15.0 * range;
            pitch2 = picth - entity.getPersistentData().m_128459_("cnt3") * 15.0 * range;

            for(int index0 = 0; (long)index0 < Math.round(30.0 * range); ++index0) {
               entity.m_146922_((float)yaw2);
               entity.m_146926_((float)pitch2);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               yaw2 += entity.getPersistentData().m_128459_("cnt2");
               pitch2 += entity.getPersistentData().m_128459_("cnt3");
               dis = 0.0;

               for(int index1 = 0; (long)index1 < Math.round(20.0 + Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.0) * 2.0); ++index1) {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
                  entity.getPersistentData().m_128347_("Damage", 15.0);
                  if (Math.round(Math.floor(dis)) > 0L) {
                     for(int index2 = 0; index2 < (int)Math.round(Math.floor(dis)); ++index2) {
                        entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                        if (entity.getPersistentData().m_128459_("Damage") < 9.0) {
                           entity.getPersistentData().m_128347_("Damage", 9.0);
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.max(CNT6, 0.75));
                  entity.getPersistentData().m_128347_("Range", 3.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (0.5 + Math.max(30.0 - dis, 0.0) / 20.0) * Math.min(CNT6, 1.0));
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  if (worldCutter) {
                     entity.getPersistentData().m_128379_("ignore", true);
                     entity.getPersistentData().m_128347_("effectConfirm", 3.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     if (Math.random() > CNT6 * 0.5) {
                        if ((!worldCutter || entity.getPersistentData().m_128459_("cnt6") >= 5.0) && world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F, false);
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                     }

                     logic_a = true;
                  }

                  if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                     entity.getPersistentData().m_128347_("BlockRange", 1.0 * CNT6);
                     entity.getPersistentData().m_128347_("BlockDamage", 6.0 * CNT6);
                     if (worldCutter) {
                        entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                        entity.getPersistentData().m_128347_("BlockDamage", 99999.0);
                     }

                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  ++dis;
                  if (!worldCutter && logic_a) {
                     logic_a = false;
                     break;
                  }
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            entity_owner = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (entity_owner instanceof Player) {
               if (entity_owner instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity_owner;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            } else if (entity_owner instanceof SukunaFushiguroEntity && entity_owner instanceof SukunaFushiguroEntity) {
               SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity_owner;
               _datEntSetL.m_20088_().m_135381_(SukunaFushiguroEntity.DATA_world_cut, true);
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
