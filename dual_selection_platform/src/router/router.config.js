export default [
    {
        path: '/CollegeIndex',
        name: 'CollegeIndex',
        component: () => import('../views/college/CollegeIndex.vue'),
        children: []
    },
    {
        path: '/',
        name: 'ScoreImport',
        component: () => import('../views/graduate/ScoreImport.vue'),
        children: []
    },
    {
        path: '/ScoreManage',
        name: 'ScoreManage',
        component: () => import('../views/graduate/ScoreManage.vue'),
        children: []
    },
    {
        path: '/InfoRetest',
        name: 'InfoRetest',
        component: () => import('../views/graduate/InfoRetest.vue'),
        children: []
    },
    {
        path: '/TeacherQuestion',
        name: 'TeacherQuestion',
        component: () => import('../views/graduate/TeacherQuestion.vue'),
        children: []
    },
    {
        path: '/ResultRelease',
        name: 'ResultRelease',
        component: () => import('../views/graduate/ResultRelease.vue'),
        children: []
    },
    {
        path: '/CandidateVolunteer',
        name: 'CandidateVolunteer',
        component: () => import('../views/college/CandidateVolunteer.vue'),
        children: []
    },
    {
        path: '/MentorManagement',
        name: 'MentorManagement',
        component: () => import('../views/college/MentorManagement.vue'),
        children: []
    },
    {
        path: '/MentorSelection',
        name: 'MentorSelection',
        component: () => import('../views/college/MentorSelection.vue'),
        children: []
    },
    {
        path: '/RecruitmentManagement',
        name: 'RecruitmentManagement',
        component: () => import('../views/college/RecruitmentManagement.vue'),
        children: []
    },
    // {
    //     path: '/addAdmissions',
    //     name: 'AddAdmissions',
    //     component: () => import('../views/college/addAdmissions.vue'),
    //     children: []
    // }
]
// {
//     path: '/knowledgeGraph',
//     name: 'knowledgeGraph',
//     component: () => import('../views/KnowledgeGraph/KnowledgeGraph.vue'),
// },
// {
//     path: '/knowledgeGraph/:entityName',
//     name: 'knowledgeGraphWithParam',
//     component: () => import('../views/KnowledgeGraph/KnowledgeGraph.vue'),
// },
// {
//     path: '/knowledgeImport',
//     name: 'knowledgeImport',
//     component: () => import('../views/KnowledgeImport/KnowledgeImport.vue'),
// },
// {
//     path: '/knowledgeEdit',
//     name: 'knowledgeEdit',
//     component: () => import('../views/KnowledgeImport/KnowledgeEdit.vue'),
// }
