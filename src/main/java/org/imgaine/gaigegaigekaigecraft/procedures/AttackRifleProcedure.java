package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BulletPistolEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackRifleProcedure {
   public AttackRifleProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double strength = 0.0;
         double range = 0.0;
         double inaccuracy = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double weapon_size = 0.0;
         double y_pos = 0.0;
         double attack_reach = 0.0;
         double pitch = 0.0;
         boolean logic_strong = false;
         boolean logic_final = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         logic_strong = entity.getPersistentData().m_128459_("skill") % 50.0 == 1.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity6 = (LivingEntity)entity;
            if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-4.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
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

            double var76 = ((Entity)var10000).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            y_pos = var76 + (double)((Entity)var10001).m_20206_() * 0.5;
            LivingEntity var77;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var77 = _mobEnt.m_5448_();
            } else {
               var77 = null;
            }

            z_pos = ((Entity)var77).m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)(logic_strong ? 8 : 2)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            label204: {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.2;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var78 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label204;
                  }
               }

               var78 = 0;
            }

            strength = (double)Math.min(var78, 50) * CNT6;
            weapon_size = GetWeaponSizeProcedure.execute(entity);
            attack_reach = GetReachProcedure.execute(entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            range = range * range * Math.sqrt(weapon_size * attack_reach);
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               dis = 1.0 + (double)entity.m_20205_() * 0.5;
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis);
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * dis);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(range * 8.0), range * 0.05, range * 0.05, range * 0.05, 1.0);
               }

               ItemStack var79;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var79 = _livEnt.m_21205_();
               } else {
                  var79 = ItemStack.f_41583_;
               }

               if (var79.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F, false);
                     }
                  }

                  if (logic_strong) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x_pos, y_pos, z_pos, 1, range * 0.0, range * 0.0, range * 0.0, 0.0);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(range * 4.0), range * 0.05, range * 0.05, range * 0.05, 1.0);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var79 = _livEnt.m_21205_();
                  } else {
                     var79 = ItemStack.f_41583_;
                  }

                  if (var79.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F, false);
                        }
                     }
                  }
               }

               logic_final = entity.getPersistentData().m_128459_("cnt5") == 0.0 || entity.getPersistentData().m_128459_("cnt5") >= 100.0;
               if (logic_strong) {
                  entity.getPersistentData().m_128347_("Damage", 3.3);
               } else if (logic_final) {
                  entity.getPersistentData().m_128347_("Damage", 2.7);
               } else {
                  entity.getPersistentData().m_128347_("Damage", 2.25);
               }

               DamageFixProcedure.execute(entity);
               if (entity instanceof Player) {
                  inaccuracy = logic_final ? 0.0 : 5.0;
               } else {
                  inaccuracy = 5.0;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var79 = _livEnt.m_21205_();
               } else {
                  var79 = ItemStack.f_41583_;
               }

               if (var79.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle")))) {
                  Level projectileLevel = entity.m_9236_();
                  if (!projectileLevel.m_5776_()) {
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BulletPistolEntity((EntityType)JujutsucraftModEntities.BULLET_PISTOL.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           entityToSpawn.m_36767_(piercing);
                           entityToSpawn.m_36762_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, (float)entity.getPersistentData().m_128459_("Damage"), 0, (byte)((int)(50.0 * CNT6)));
                     _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                     _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)((double)(logic_strong ? 5 : 4) * CNT6), (float)inaccuracy);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var79 = _livEnt.m_21205_();
                  } else {
                     var79 = ItemStack.f_41583_;
                  }

                  if (var79.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
                     Level projectileLevel = entity.m_9236_();
                     if (!projectileLevel.m_5776_()) {
                        Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new Arrow(EntityType.f_20548_, level);
                              entityToSpawn.m_5602_(shooter);
                              entityToSpawn.m_36781_((double)damage);
                              entityToSpawn.m_36735_(knockback);
                              entityToSpawn.m_36767_(piercing);
                              entityToSpawn.m_36762_(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, (float)entity.getPersistentData().m_128459_("Damage"), 0, (byte)((int)(50.0 * CNT6)));
                        _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                        _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)((double)(logic_strong ? 5 : 4) * CNT6), (float)inaccuracy);
                        projectileLevel.m_7967_(_entityToSpawn);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)(9 + (logic_strong ? 8 : 2))) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
