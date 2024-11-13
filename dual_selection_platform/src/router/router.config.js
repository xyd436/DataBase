export default [
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
    }
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
