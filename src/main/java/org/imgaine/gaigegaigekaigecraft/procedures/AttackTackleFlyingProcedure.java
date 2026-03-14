package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiRikaDhruvEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleFlyingProcedure {
   public AttackTackleFlyingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean projection_sorcery = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_skill = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double rnd = 0.0;
         double y_fix_height = 0.0;
         double test_x = 0.0;
         double test_y = 0.0;
         double test_z = 0.0;
         double old_mode = 0.0;
         double distance = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.f_19789_ = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         targeting = var10000 instanceof LivingEntity;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            int var110;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
               var110 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
            } else {
               var110 = 0;
            }

            label242: {
               if (var110 != 0) {
                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                     var110 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
                  } else {
                     var110 = 0;
                  }

                  if (var110 != 2) {
                     var110 = 0;
                     break label242;
                  }
               }

               var110 = 1;
            }

            projection_sorcery = (boolean)var110;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               ((ZeninNaoyaCursedSpiritEntity)entity).setAnimation("fly");
            }
         }

         speed = projection_sorcery ? 2.0 : 1.0;
         int var113;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
            var113 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
         } else {
            var113 = 0;
         }

         if (var113 == 2) {
            speed = 3.0;
         }

         dis = GetDistanceProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") > 10.0 && projection_sorcery && Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0)) > 3.0 && Math.sqrt(Math.pow(entity.m_20185_() - entity.getPersistentData().m_128459_("old_x"), 2.0) + Math.pow(entity.m_20186_() - entity.getPersistentData().m_128459_("old_y"), 2.0) + Math.pow(entity.m_20189_() - entity.getPersistentData().m_128459_("old_z"), 2.0)) > 1.0) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
               } else {
                  _level.m_7785_(x, y + (double)entity.m_20206_() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * 0.5, z, 5, 1.0, 1.0, 1.0, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x, y + (double)entity.m_20206_() * 0.5, z, 5, 1.0, 1.0, 1.0, 1.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") % 2.0 == 1.0) {
               entity.getPersistentData().m_128347_("BlockRange", 8.0);
               entity.getPersistentData().m_128347_("BlockDamage", 0.33);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
            entity.getPersistentData().m_128347_("cnt4", (double)(Math.random() < 0.5 ? 1 : -1));
            if (targeting) {
               if (dis < 32.0) {
                  LivingEntity var114;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var114 = _mobEnt.m_5448_();
                  } else {
                     var114 = null;
                  }

                  x_pos = ((Entity)var114).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var114 = _mobEnt.m_5448_();
                  } else {
                     var114 = null;
                  }

                  double var116 = ((Entity)var114).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var116 + (double)((Entity)var10001).m_20206_() * 0.9;
                  LivingEntity var117;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var117 = _mobEnt.m_5448_();
                  } else {
                     var117 = null;
                  }

                  z_pos = ((Entity)var117).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", 10.0);
               }
            }

            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(45.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128379_("canFly", true);
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * -3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * -3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * -3.0);
            GetPowerFixProcedure.execute(entity);
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            distance = (double)(-16.0F - entity.m_20205_());
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance);
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);
         } else if (entity.getPersistentData().m_128459_("cnt1") <= 50.0) {
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               y_fix = 0.0;

               for(int index0 = 0; index0 < 255 && world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - y_fix, z_pos)); ++index0) {
                  if (y_pos - y_fix < 0.0) {
                     y_fix = 255.0;
                     break;
                  }

                  ++y_fix;
               }

               if (y_fix > 24.0) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (y_fix - 24.0));
               } else if (y_fix < 16.0) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + 16.0 - y_fix);
               }

               if (targeting) {
                  CompoundTag var118 = entity.getPersistentData();
                  double var10002 = entity.getPersistentData().m_128459_("y_pos");
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  double var124 = ((Entity)var10003).m_20186_();
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  var118.m_128347_("y_pos", Math.max(var10002, var124 + (double)((Entity)var10004).m_20206_() * 0.9 + 8.0));
               }
            }

            if (!projection_sorcery) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 30.0));
            }

            if (dis > 64.0) {
               entity.getPersistentData().m_128347_("cnt1", 50.0);
            } else {
               RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
               dis = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_pos") - entity.m_20185_(), 2.0) + Math.pow(entity.getPersistentData().m_128459_("y_pos") - (entity.m_20186_() + (double)entity.m_20206_() * 0.9), 2.0) + Math.pow(entity.getPersistentData().m_128459_("z_pos") - entity.m_20189_(), 2.0));
               entity.m_146922_((float)((double)entity.m_146908_() + 100.0 * (1.0 - Math.min(Math.max(dis - 16.0, 0.0), 16.0) / 16.0) * entity.getPersistentData().m_128459_("cnt4")));
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               distance = (double)(64.0F + entity.m_20205_());
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
               entity.getPersistentData().m_128379_("canFly", true);
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt2") != 2.0) {
               entity.getPersistentData().m_128347_("cnt2", 2.0);
               if (entity instanceof ShikigamiRikaDhruvEntity) {
                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.5);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.5);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.5);
               } else {
                  if (targeting) {
                     LivingEntity var119;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var119 = _mobEnt.m_5448_();
                     } else {
                        var119 = null;
                     }

                     x_pos = ((Entity)var119).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var119 = _mobEnt.m_5448_();
                     } else {
                        var119 = null;
                     }

                     double var121 = ((Entity)var119).m_20186_();
                     LivingEntity var123;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var123 = _mobEnt.m_5448_();
                     } else {
                        var123 = null;
                     }

                     y_pos = var121 + (double)((Entity)var123).m_20206_() * 0.75;
                     LivingEntity var122;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var122 = _mobEnt.m_5448_();
                     } else {
                        var122 = null;
                     }

                     z_pos = ((Entity)var122).m_20189_();
                  } else {
                     distance = (double)(64.0F + entity.m_20205_());
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  }

                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, entity.getPersistentData().m_128459_("y_power") * speed, entity.getPersistentData().m_128459_("z_power") * speed));
            RotateEntityProcedure.execute(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 16.0, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.getPersistentData().m_128459_("y_power") * 16.0, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 16.0, entity);
            x_pos = entity.getPersistentData().m_128459_("old_x");
            y_pos = entity.getPersistentData().m_128459_("old_y");
            z_pos = entity.getPersistentData().m_128459_("old_z");
            vx = x_pos - x;
            vy = y_pos - y;
            vz = z_pos - z;
            dis = Math.sqrt(Math.pow(vx, 2.0) + Math.pow(vy, 2.0) + Math.pow(vz, 2.0));
            if (entity instanceof ShikigamiRikaDhruvEntity) {
               if (entity.getPersistentData().m_128459_("cnt1") > 80.0) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else {
               if (dis > 0.0) {
                  vx /= dis;
                  vy /= dis;
                  vz /= dis;
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * speed);
                  entity.getPersistentData().m_128347_("y_knockback", 0.5);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * speed);

                  for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
                     entity.getPersistentData().m_128347_("Damage", 16.0 + Math.pow(speed, 2.0) * 2.0);
                     entity.getPersistentData().m_128347_("Range", (double)(4.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("knockback", 0.1 * speed);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                     x_pos += vx * 1.0;
                     y_pos += vy * 1.0;
                     z_pos += vz * 1.0;
                  }

                  entity.getPersistentData().m_128347_("x_knockback", 0.0);
                  entity.getPersistentData().m_128347_("y_knockback", 0.0);
                  entity.getPersistentData().m_128347_("z_knockback", 0.0);
               }

               if (dis < 24.0 && entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt1"));
               }

               if (projection_sorcery) {
                  if (entity.getPersistentData().m_128459_("cnt1") >= entity.getPersistentData().m_128459_("cnt3") + 24.0 / Math.max(speed, 1.0) || entity.getPersistentData().m_128459_("cnt1") > 80.0 + 24.0 / Math.max(speed, 1.0)) {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt1") >= entity.getPersistentData().m_128459_("cnt3") + 20.0 + 24.0 / Math.max(speed, 1.0) || entity.getPersistentData().m_128459_("cnt1") > 115.0 + 24.0 / Math.max(speed, 1.0)) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().m_128347_("old_x", x);
         entity.getPersistentData().m_128347_("old_y", y);
         entity.getPersistentData().m_128347_("old_z", z);
      }
   }
}
