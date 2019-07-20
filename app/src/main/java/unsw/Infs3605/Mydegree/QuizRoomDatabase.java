package unsw.Infs3605.Mydegree;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Quiz.class}, version = 4)
public abstract class QuizRoomDatabase extends RoomDatabase {

    public abstract QuizDao quizDao();

    private static volatile QuizRoomDatabase INSTANCE;

    static QuizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizRoomDatabase.class, "quiz_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final QuizDao mDao;

        PopulateDbAsync(QuizRoomDatabase db) {
            mDao = db.quizDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mDao.deleteAll();

            Quiz quiz = new Quiz(1, 1, true, false,
                    3,
                    "What is the limit of year 1 courses you can take?",
                    "8",
                    "9",
                    "10",
                    "11",
                    "The Information Systems Degree limits students to only completing 10 level 1 courses (60 UOC). There are 7 compulsory level 1 courses in the Information Systems degree so a maximum of 3 extra level 1 courses can be completed."
            );
            mDao.insert(quiz);

            quiz = new Quiz(2, 1, false, false,
                    1,
                    "INFS1603 is a core course",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS1603 is one of the core courses for the INFS degree"
            );
            mDao.insert(quiz);

            quiz = new Quiz(3, 1, false, false,
                    2,
                    "INFS1603 has prerequisite courses than need to be completed",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS1603 is a level 1 course that does not require any prerequisite knowledge"
            );
            mDao.insert(quiz);

            quiz = new Quiz(4, 1, true, false,
                    2,
                    "Which of these is not a compulsory level 1 course?",
                    "INFS1602",
                    "FINS1613",
                    "INFS1609 ",
                    "MGMT1001",
                    "INFS1602, INFS1609 and MGMT1001 are all compulsory courses that students must complete. FINS1613 however, is not mandatory but can be completed as a free elective."
            );
            mDao.insert(quiz);

            quiz = new Quiz(5, 2, false, false,
                    2,
                    "I have to complete all my level 1 courses before I can start my level 2 courses.",
                    "True",
                    "False",
                    "",
                    "",
                    "While level 2 courses will have prerequisite courses, students are able to complete some courses without having completed all of their level 1 courses. For example, INFS2603 only INFS1602 and INFS1603 as prerequisites but not INFS1609."
            );
            mDao.insert(quiz);




            quiz = new Quiz(6, 2, true, false,
                    4,
                    "How many compulsory courses are there in the INFS degree?",
                    "13",
                    "14",
                    "15",
                    "16",
                    "There are 16 courses (96 UOC) which are considered compulsory for the Information Systems Degree. If you do not complete any of the courses, you will not be elligible to graduate."
            );
            mDao.insert(quiz);

            quiz = new Quiz(7, 2, true, false,
                    1,
                    "Which of the following is not a compulsory level 2 course?",
                    "INFS2631",
                    "INFS2621",
                    "INFS2628",
                    "INFS2605",
                    "INFS2621, INFS2628, and INFS2605 are all level core courses along with INFS2603. INFS2631 is an Information Systems elective."
            );
            mDao.insert(quiz);

            quiz = new Quiz(8, 2, true, false,
                    2,
                    "How many General Education Courses can you take?",
                    "1",
                    "2",
                    "3",
                    "4",
                    "You are required to complete 2 general education courses (12UOC), which are courses taken outside of the Business School."
            );
            mDao.insert(quiz);

            quiz = new Quiz(9, 3, false, false,
                    2,
                    "I have to complete all my level 1 and level 2 courses before I can start my level 3 courses.",
                    "True",
                    "False",
                    "",
                    "",
                    "While level 3 courses will have prerequisite courses, students are able to complete some courses without having completed all of their level 1 and level 2 courses."
            );
            mDao.insert(quiz);

            quiz = new Quiz(10, 3, true, false,
                    3,
                    "What is the minimum number of Stage 2/3 Information Systems Electives that I must complete?",
                    "0",
                    "1",
                    "2",
                    "3",
                    "2 electives must be chosen out of the following five courses: INFS2631, INFS3020, INFS3632, INFS3830, and INFS3873"
            );
            mDao.insert(quiz);



            quiz = new Quiz(11, 3, true, false,
                    4,
                    "Which of the following is a compulsory level 3 course?",
                    "INFS3830",
                    "INFS3632",
                    "INFS3020",
                    "INFS3634",
                    "INFS3634 is a compulsory level 3 course while the other 3 INFS3830, INFS3632, and INFS3020 are all considered electives"
            );
            mDao.insert(quiz);

            quiz = new Quiz(12, 3, false, false,
                    1,
                    "INFS3873 is a Information Systems Elective",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS3873 is an elective that can be completed by an INFS student. 2 electives must be chosen out of the following five: INFS2631, INFS3020, INFS3632, INFS3830, and INFS3873"
            );


           mDao.insert(quiz);

           /* quiz = new Quiz(13, 3, true, false,
                    1,
                    "If you have arthritis, you should:",
                    "Walk regularly for exercise",
                    "Avoid walking too much -- it strains your joints",
                    "Walking won't help or hurt you",
                    "Have a can of cock and play viedo game",
                    "Got achy, creaky knees or hips? You have good reason to get walking then. For starters, your joint fluid moves around when you do, and that gets oxygen and nutrients to your joints and cartilage and helps prevent friction. It also strengthens your leg and core muscles. When your muscles do more of the work, your joints hurt less. A regular walk may also help you slim down, and a thinner body means less pressure on your joints." );

            mDao.insert(quiz);

            quiz = new Quiz(14, 3, true, false,
                    4,
                    "Which of the following types of muscles is most likely to cause DOMS?",
                    "Isometric",
                    "Isokinetic",
                    "Concentric",
                    "Eccentric",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(15, 3, true, false,
                    2,
                    "What body type had broad shoulders and a muscular build?",
                    "Ectomorph",
                    "Mesomorph",
                    "Endomorph",
                    "Somatotype",
                    "");
            mDao.insert(quiz);




            quiz = new Quiz(16, 4, true, false,
                    2,
                    "According to the food stndards agency which of the following food groups makes up one of the largest sections of the food plate?",
                    "Milk and dairy foods",
                    "Fruits and vegetables",
                    "Meat fish egg and beans",
                    "None of the above.",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(17, 4, true, false,
                    1,
                    "Which of the following is a non dairy source of protein ",
                    "Beans",
                    "Cheese",
                    "Milk",
                    "Yoghurt",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(18, 4, true, false,
                    3,
                    "Which of the following is a negative effect of dehydration?",
                    "Increased oxygen uptake",
                    "Decreased oxygen uptake",
                    "Increase fatigue",
                    "Decrease fatigue",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(19, 4, true, false,
                    2,
                    "Which of the following is a source of carbohydrates in the diet?",
                    "Chicken",
                    "Pasta",
                    "Cheese",
                    "Pork",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(20, 4, true, false,
                    1,
                    "For an individual who is obese which of the following would be a positive change to their diet?",
                    "Decrease intake of saturated fat",
                    "Decrease intake of fruit and vegetables",
                    "Increase salt intake",
                    "None of the above",
                    "");
            mDao.insert(quiz);



            quiz = new Quiz(21, 5, false, false,
                    1,
                    "When you lift weights, you should feel the burn, and tire out your muscles. ",
                    "True",
                    "False",
                    "",
                    "",
                    "Working your muscles to the point of tiredness is a good way to strengthen and tone them. Just be sure to use good form and control the motion. \n" +
                            "\n" +
                            "Each time you lift the weight, it's called a repetition, or \"rep.\" Start with one set of 8 to 12 reps. Gradually increase the weight and the number of sets as you get stronger. You can use free weights, resistance bands, or gym machines.");
            mDao.insert(quiz);

            quiz = new Quiz(22, 5, false, false,
                    2,
                    "'No pain, no gain.'",
                    "True",
                    "False",
                    "",
                    "",
                    "Pain means you should stop what you’re doing and see a doctor before you start up again. Sore muscles are a different story. It's normal to feel a bit tender, especially when you're new to working out. So start slowly, but don’t let it keep you down. Some discomfort means you’re pushing your body to bring on change.");
            mDao.insert(quiz);

            quiz = new Quiz(23, 5, true, false,
                    1,
                    "What is the most balanced exercise plan?",
                    "Walking, weight lifting, and yoga",
                    "Running, weight lifting, and tennis",
                    "Running, weight lifting, and cycling",
                    "Walking, eating and cycling",
                    "This plan has three different types of exercise: aerobic activity or cardio (walking), strength or resistance training (weights), and flexibility training (yoga). And all of them are important. \n" +
                            "\n" +
                            "Walking and other cardio workouts like jogging, cycling, swimming, and tennis boost the power of your heart and lungs. Weight lifting builds muscle, keeps your bones strong, and helps with balance and coordination. Yoga can increase your range of motion and lower your chances of getting injured.");
            mDao.insert(quiz);

            quiz = new Quiz(24, 5, false, false,
                    2,
                    "Do your cardio exercises before your strength training",
                    "True",
                    "False",
                    "",
                    "",
                    "There's no \"correct\" order, but it can make a difference if you have a specific goal in mind. Do cardio first if you want to work on your endurance. Pump iron first if you want to build strength or bigger muscles.\n" +
                            "\n" +
                            "The most important thing is to get enough of both types of exercise every week.");
            mDao.insert(quiz);

            quiz = new Quiz(25, 5, true, false,
                    3,
                    "What’s the toughest workout?",
                    "Shopping",
                    "Doing laundry",
                    "Pushing a lawn mower",
                    "Eating burger",
                    "Bad news, shopaholics. Skimming the racks won’t speed up your breathing or heart rate. Neither does sorting your colors from your whites. Those activities don’t count as a workout. Pushing a lawnmower, though, can qualify as a moderate-intensity exercise if you do it for 10 minutes or longer.\n" +
                            "\n" +
                            "So what’s moderate intensity? It’s when you can talk but not sing the words of your favorite song. Vigorous intensity is when you’re breathing hard and fast and can’t get out more than a couple of words.");
            mDao.insert(quiz);



            quiz = new Quiz(26, 6, false, false,
                    2,
                    "Thirty minutes of straight exercise is better than 10 minutes three times a day.",
                    "True",
                    "False",
                    "",
                    "",
                    "It’s fine to train throughout the day. Just stick to a minimum of 10 minutes at a time to get your heart rate up.\n" +
                            "\n" +
                            "The CDC recommends you get at least 150 minutes a week of moderate-intensity cardio exercise or 75 minutes at vigorous intensity.\n" +
                            "\n" +
                            "You can get the same fitness perks in half the time with vigorous exercises. Jog, swim laps, cycle fast, or play a sport that involves a lot of running, for example.");
            mDao.insert(quiz);

            quiz = new Quiz(27, 6, false, false,
                    1,
                    "You should warm up every time you exercise and cool down afterward.",
                    "True",
                    "False",
                    "",
                    "",
                    "Don't skip these important steps. A warm-up of light aerobics to slightly raise your breathing and heart rate can prepare your muscles and help you avoid an injury. A brisk walk or a steady bike ride for 5 to10 minutes -- or until you break a sweat -- should do the trick.\n" +
                            "\n" +
                            "After your workout, cool down for the same amount of time to help your body recover. Simply continue your exercise session at a lower level of intensity. Include gentle stretching to loosen your muscles, tendons, and ligaments to cut soreness." );
            mDao.insert(quiz);

            quiz = new Quiz(28, 6, true, false,
                    3,
                    "What target heart rate should you aim for during cardio?",
                    "Twice your resting heart rate",
                    "Three times your resting heart rate",
                    "50% to 85% of your maximum heart rate",
                    "",
                    "Here’s where you’ll really help your ticker. If you've just started exercising, aim for the lower end of this range and work your way up.\n" +
                            "\n" +
                            "To find your maximum heart rate, subtract your age from 220.\n" +
                            "\n" +
                            "To take your pulse, place your fingers on your wrist or on the side of your neck, and count the number of beats in a minute.");
            mDao.insert(quiz);

            quiz = new Quiz(29, 6, false, false,
                    2,
                    "Water is always better than sports drinks.",
                    "True",
                    "False",
                    "",
                    "",
                    "H2O is usually the best choice, especially during normal, daily exercise. But if you’re pushing hard for more than an hour, sports drinks can be just as good or better. They give you energy through carbohydrates and replace electrolytes lost through sweat. That helps you work out longer." );
            mDao.insert(quiz);

            quiz = new Quiz(30, 6, false, false,
                    2,
                    "Everyone needs to check with their doctor before starting an exercise program.",
                    "True",
                    "False",
                    "",
                    "",
                    "Don’t let another excuse keep you from a healthy habit. Most people can go ahead and hit the gym. You should check with your doctor, though, if you:\n" +
                            "\n" +
                            "     --Are a man over 45 or a woman over 55, and you plan on doing vigorous workouts\n" +
                            "\n" +
                            "     --Have any medical problem such as diabetes or heart disease\n" +
                            "\n" +
                            "     --Have joint problems like arthritis\n" +
                            "\n" +
                            "     --Take blood pressure or heart meds");
            mDao.insert(quiz);


            quiz = new Quiz(31, 7, false, false,
                    2,
                    "You can target specific parts of your body to lose weight.",
                    "True",
                    "False",
                    "",
                    "",
                    "This idea is known as 'spot reducing', and guess what? It's a myth! Your body sheds fat evenly across your body. So you can’t just do a million crunches to zap your 'muffin top'. You have to do a full-body workout to lose belly fat. Then you'll be able to show off your abs that all those sit-ups earned you.");
            mDao.insert(quiz);


            quiz = new Quiz(32, 7, true, false,
                    4,
                    "Which “mind-body” exercise can improve your fitness?",
                    "Yoga",
                    "Pilates",
                    "Tai chi",
                    "All of the above",
                    "All three practices can boost your flexibility, strength, balance, and overall fitness. Yoga has challenging poses that get your heart rate going. Pilates involves tough strength training. And tai chi lowers your blood pressure.\n" +
                            "\n" +
                            "Think about adding these exercises to balance your workout.");
            mDao.insert(quiz);

            quiz = new Quiz(33, 7, false, false,
                    2,
                    "It’s better to work out in the morning than in the afternoon or evening.",
                    "True",
                    "False",
                    "",
                    "",
                    "What’s the best time to exercise? Whenever you can make it a part of your routine. Research shows that your body will adjust to whatever time of day works for you. Some studies say physical performance peaks in the late afternoon. Others say that morning workouts help you sleep better. The most important thing is to pick a time of day you can stick with.");
            mDao.insert(quiz);

            quiz = new Quiz(34, 7, true, false,
                    2,
                    "While exercising, most people should break for water every:",
                    "5 minutes",
                    "20 minutes",
                    "40 minutes",
                    "1 hour",
                    "Correct! Most people would stay hydrated by drinking 5 to 10 ounces of fluid every 20 minutes, but your exact need depends on how hard you’re exercising, whether you are indoors or outdoors, your age, gender, and weight." );
            mDao.insert(quiz);

            quiz = new Quiz(35, 7, true, false,
                    1,
                    "If you have arthritis, you should:",
                    "Walk regularly for exercise",
                    "Avoid walking too much -- it strains your joints",
                    "Walking won't help or hurt you",
                    "Have a can of cock and play viedo game",
                    "Got achy, creaky knees or hips? You have good reason to get walking then. For starters, your joint fluid moves around when you do, and that gets oxygen and nutrients to your joints and cartilage and helps prevent friction. It also strengthens your leg and core muscles. When your muscles do more of the work, your joints hurt less. A regular walk may also help you slim down, and a thinner body means less pressure on your joints." );
            mDao.insert(quiz);




            quiz = new Quiz(36, 8, true, false,
                    1,
                    "Brisk walking counts as cardio exercise.",
                    "True",
                    "False",
                    "It depends",
                    "I am not sure",
                    "Ideally, you should log at least 150 minutes of exercise that raises your heart rate every week. Walking can definitely count toward this goal. You don’t need any special equipment (except a decent pair of shoes), and you can do it practically anywhere. But to get cardio credit, you have to do more than stroll to the fridge and back. If you can belt out a song, you need to pick up the pace.");
            mDao.insert(quiz);

            quiz = new Quiz(37, 8, true, false,
                    1,
                    "Walking is as good for your heart as running.",
                    "True, if you do enough of it",
                    "False, you need to riase your heart rate",
                    "Neither is really good for your heart",
                    "The top",
                    "For years, many experts thought that really pushing yourself -- and your heart rate -- was the best way to strengthen your heart. But it turns out that brisk walking is just as good when it comes to cutting your risk of high blood pressure, high cholesterol, and diabetes -- as long as you do about twice as much of it.");
            mDao.insert(quiz);


            quiz = new Quiz(38, 8, true, false,
                    3,
                    "You should do this many minutes of brisk walking each week if you want to lose weight:",
                    "About 75",
                    "About 150",
                    "About 300",
                    "About 999",
                    "That may sound like a lot, but it breaks down to less than 45 minutes a day -- a reasonable target if you're serious about shaping up. But if your schedule is packed, you can burn just as many calories with 20 minutes of exercise called high-intensity interval training (HIIT): 20 seconds of an energetic activity, like running, followed by 1 minute of recovery (walking). This jump-starts your metabolism so your body can burn more fat.");
            mDao.insert(quiz);


            quiz = new Quiz(39, 8, true, false,
                    1,
                    "Take your dog for a half-hour walk, and you may burn about:",
                    "100 calories",
                    "200 calories",
                    "300 calories",
                    "900 calories",
                    "Everyone burns calories at a different rate -- this number is for someone who weighs 150 pounds. But the idea is the same: Give in to the pooch with the pleading eyes, and you can torch some calories. ");
            mDao.insert(quiz);


            quiz = new Quiz(40, 8, true, false,
                    2,
                    "Exercise like walking lowers your risk of breast cancer because it:",
                    "Turns off genes that let cancer cells grow",
                    "Lowers the estrogen in your bloodstream",
                    "Protects your cells",
                    "Protects your hair",
                    "Women who are active are 30% to 40% less likely to get breast cancer. Women and men who walk briskly or do other physical activities regularly are also much less likely than others to have colon cancer. To cut your cancer risk, try to walk at least 30 minutes almost every day.");
            mDao.insert(quiz);*/



            return null;
        }
    }

}
