package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SwitchBlastGameProcedure {
   public SwitchBlastGameProcedure() {
   }

   public static void execute(LevelAccessor world, final CommandContext<CommandSourceStack> arguments) {
      JujutsucraftModVariables.MapVariables.get(world).BlastGameDistance = (double)Math.round(DoubleArgumentType.getDouble(arguments, "distance"));
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter = ((<undefinedtype>)(new Object() {
         public double getX() {
            try {
               return (double)BlockPosArgument.m_118242_(arguments, "position").m_123341_();
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return 0.0;
            }
         }
      })).getX();
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter = ((<undefinedtype>)(new Object() {
         public double getY() {
            try {
               return (double)BlockPosArgument.m_118242_(arguments, "position").m_123342_();
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return 0.0;
            }
         }
      })).getY();
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter = ((<undefinedtype>)(new Object() {
         public double getZ() {
            try {
               return (double)BlockPosArgument.m_118242_(arguments, "position").m_123343_();
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return 0.0;
            }
         }
      })).getZ();
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(((<undefinedtype>)(new Object() {
            public double getX() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123341_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getX(), ((<undefinedtype>)(new Object() {
            public double getY() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123342_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getY(), ((<undefinedtype>)(new Object() {
            public double getZ() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123343_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getZ()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "worldborder center ~ ~");
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(((<undefinedtype>)(new Object() {
            public double getX() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123341_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getX(), ((<undefinedtype>)(new Object() {
            public double getY() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123342_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getY(), ((<undefinedtype>)(new Object() {
            public double getZ() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123343_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getZ()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "worldborder set " + Math.round(DoubleArgumentType.getDouble(arguments, "distance")));
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(((<undefinedtype>)(new Object() {
            public double getX() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123341_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getX(), ((<undefinedtype>)(new Object() {
            public double getY() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123342_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getY(), ((<undefinedtype>)(new Object() {
            public double getZ() {
               try {
                  return (double)BlockPosArgument.m_118242_(arguments, "position").m_123343_();
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return 0.0;
               }
            }
         })).getZ()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "worldborder add 5");
      }

      JujutsucraftModVariables.MapVariables.get(world).BlastGame = true;
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      if (!world.m_5776_() && world.m_7654_() != null) {
         world.m_7654_().m_6846_().m_240416_(Component.m_237113_("\"Blast Game\" has switched to " + JujutsucraftModVariables.MapVariables.get(world).BlastGame), false);
      }

   }
}
