/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

import java.io.File;
import java.util.HashMap;

public class TrajectoryLoader {

    private File m_directory;
    private HashMap<String, Trajectory> m_trajMap;

    public TrajectoryLoader(String directoryFilePath) {
        m_directory = new File(directoryFilePath);
        m_trajMap = new HashMap<>();
        for (File traj : m_directory.listFiles()) {
            if (traj.getName().contains(".traj")) {
                m_trajMap.put(traj.getName(), Pathfinder.readFromFile(traj));
            }
            System.out.println(traj.getName());
        }
    }

    public Trajectory getTrajectory(String trajName) {
        return  m_trajMap.get(trajName + ".traj");
    }
}
