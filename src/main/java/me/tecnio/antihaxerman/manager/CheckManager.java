/*
 *  Copyright (C) 2020 - 2021 Tecnio
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package me.tecnio.antihaxerman.manager;

import me.tecnio.antihaxerman.check.Check;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimA;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimB;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimC;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimD;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimE;
import me.tecnio.antihaxerman.check.impl.combat.aim.AimF;
import me.tecnio.antihaxerman.check.impl.combat.angle.AngleA;
import me.tecnio.antihaxerman.check.impl.combat.aura.AuraA;
import me.tecnio.antihaxerman.check.impl.combat.aura.AuraB;
import me.tecnio.antihaxerman.check.impl.combat.autoblock.AutoBlockA;
import me.tecnio.antihaxerman.check.impl.combat.autoblock.AutoBlockB;
import me.tecnio.antihaxerman.check.impl.combat.autoclicker.*;
import me.tecnio.antihaxerman.check.impl.combat.reach.ReachA;
import me.tecnio.antihaxerman.check.impl.combat.velocity.VelocityA;
import me.tecnio.antihaxerman.check.impl.combat.velocity.VelocityB;
import me.tecnio.antihaxerman.check.impl.movement.fastclimb.FastClimbA;
import me.tecnio.antihaxerman.check.impl.movement.fastclimb.FastClimbB;
import me.tecnio.antihaxerman.check.impl.movement.flight.FlightA;
import me.tecnio.antihaxerman.check.impl.movement.flight.FlightB;
import me.tecnio.antihaxerman.check.impl.movement.flight.FlightC;
import me.tecnio.antihaxerman.check.impl.movement.flight.FlightD;
import me.tecnio.antihaxerman.check.impl.movement.jesus.JesusA;
import me.tecnio.antihaxerman.check.impl.movement.jesus.JesusB;
import me.tecnio.antihaxerman.check.impl.movement.jesus.JesusC;
import me.tecnio.antihaxerman.check.impl.movement.largemove.LargeMoveA;
import me.tecnio.antihaxerman.check.impl.movement.largemove.LargeMoveB;
import me.tecnio.antihaxerman.check.impl.movement.liquidspeed.LiquidSpeedA;
import me.tecnio.antihaxerman.check.impl.movement.liquidspeed.LiquidSpeedB;
import me.tecnio.antihaxerman.check.impl.movement.liquidspeed.LiquidSpeedC;
import me.tecnio.antihaxerman.check.impl.movement.motion.*;
import me.tecnio.antihaxerman.check.impl.movement.noslow.NoSlowA;
import me.tecnio.antihaxerman.check.impl.movement.noslow.NoSlowB;
import me.tecnio.antihaxerman.check.impl.movement.noslow.NoSlowC;
import me.tecnio.antihaxerman.check.impl.movement.omnisprint.OmniSprintA;
import me.tecnio.antihaxerman.check.impl.movement.speed.*;
import me.tecnio.antihaxerman.check.impl.movement.strafe.StrafeA;
import me.tecnio.antihaxerman.check.impl.player.badpackets.*;
import me.tecnio.antihaxerman.check.impl.player.groundspoof.GroundSpoofA;
import me.tecnio.antihaxerman.check.impl.player.groundspoof.GroundSpoofB;
import me.tecnio.antihaxerman.check.impl.player.groundspoof.GroundSpoofC;
import me.tecnio.antihaxerman.check.impl.player.groundspoof.GroundSpoofD;
import me.tecnio.antihaxerman.check.impl.player.interact.*;
import me.tecnio.antihaxerman.check.impl.player.inventory.InventoryA;
import me.tecnio.antihaxerman.check.impl.player.inventory.InventoryB;
import me.tecnio.antihaxerman.check.impl.player.inventory.InventoryC;
import me.tecnio.antihaxerman.check.impl.player.post.*;
import me.tecnio.antihaxerman.check.impl.player.scaffold.ScaffoldA;
import me.tecnio.antihaxerman.check.impl.player.timer.TimerA;
import me.tecnio.antihaxerman.check.impl.player.timer.TimerB;
import me.tecnio.antihaxerman.check.impl.player.timer.TimerC;
import me.tecnio.antihaxerman.check.impl.player.timer.TimerD;
import me.tecnio.antihaxerman.config.Config;
import me.tecnio.antihaxerman.data.PlayerData;
import org.bukkit.Bukkit;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public final class CheckManager {

    public static final Class<?>[] CHECKS = new Class[]{
            AimA.class,
            AimB.class,
            AimC.class,
            AimD.class,
            AimE.class,
            AimF.class,
            AuraA.class,
            AuraB.class,
            AutoClickerF.class,
            AutoClickerA.class,
            AutoClickerB.class,
            AutoClickerC.class,
            AutoClickerD.class,
            AutoClickerE.class,
            AutoBlockA.class,
            AutoBlockB.class,
            ReachA.class,
            AngleA.class,
            VelocityA.class,
            VelocityB.class,
            SpeedA.class,
            SpeedB.class,
            SpeedC.class,
            SpeedD.class,
            SpeedE.class,
            SpeedF.class,
            FlightA.class,
            FlightB.class,
            FlightC.class,
            FlightD.class,
            StrafeA.class,
            MotionA.class,
            MotionB.class,
            MotionC.class,
            MotionD.class,
            MotionE.class,
            MotionF.class,
            NoSlowA.class,
            NoSlowB.class,
            NoSlowC.class,
            OmniSprintA.class,
            LargeMoveA.class,
            LargeMoveB.class,
            FastClimbA.class,
            FastClimbB.class,
            JesusA.class,
            JesusB.class,
            JesusC.class,
            LiquidSpeedA.class,
            LiquidSpeedB.class,
            LiquidSpeedC.class,
            GroundSpoofA.class,
            GroundSpoofB.class,
            GroundSpoofC.class,
            GroundSpoofD.class,
            TimerA.class,
            TimerB.class,
            TimerC.class,
            TimerD.class,
            PostA.class,
            PostB.class,
            PostC.class,
            PostD.class,
            PostE.class,
            PostF.class,
            PostG.class,
            InventoryA.class,
            InventoryB.class,
            InventoryC.class,
            InventoryC.class,
            ScaffoldA.class,
            InteractA.class,
            InteractB.class,
            InteractC.class,
            InteractD.class,
            InteractE.class,
            BadPacketsA.class,
            BadPacketsB.class,
            BadPacketsC.class,
            BadPacketsD.class,
            BadPacketsG.class,
            BadPacketsH.class,
            BadPacketsI.class,
            BadPacketsJ.class,
            BadPacketsK.class,
            BadPacketsM.class,
    };

    private static final List<Constructor<?>> CONSTRUCTORS = new ArrayList<>();

    public static List<Check> loadChecks(final PlayerData data) {
        final List<Check> checkList = new ArrayList<>();
        for (final Constructor<?> constructor : CONSTRUCTORS) {
            try {
                checkList.add((Check) constructor.newInstance(data));
            } catch (final Exception exception) {
                System.err.println("Failed to load checks for " + data.getPlayer().getName());
                exception.printStackTrace();
            }
        }
        return checkList;
    }

    public static void setup() {
        for (final Class<?> clazz : CHECKS) {
            if (Config.ENABLED_CHECKS.contains(clazz.getSimpleName())) {
                try {
                    CONSTRUCTORS.add(clazz.getConstructor(PlayerData.class));
                    Bukkit.getLogger().info(clazz.getSimpleName() + " is enabled!");
                } catch (final NoSuchMethodException exception) {
                    exception.printStackTrace();
                }
            } else {
                Bukkit.getLogger().info(clazz.getSimpleName() + " is disabled! " + Config.ENABLED_CHECKS.size());
            }
        }
    }
}

