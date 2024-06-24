package com.uz.ustudy.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uz.ustudy.R
import com.uz.ustudy.ui.courses.adapter.CoursesAdapter

class CourseOptionFragment : Fragment() {

    private lateinit var subject: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_option, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val courses = getCourses(subject)
        val adapter = CoursesAdapter(courses)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        private const val ARG_SUBJECT = "subject"

        fun newInstance(subject: String) = CourseOptionFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_SUBJECT, subject)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            subject = it.getString(ARG_SUBJECT).toString()
        }
    }

    private fun getCourses(subject: String): List<Course> {
        return when (subject) {
            "English" -> listOf(
                Course("English 101", "Introduction to English Literature: This course provides a comprehensive overview of English literature from the medieval period to the contemporary era. Students will explore various genres including poetry, drama, and prose, and analyze works from authors such as Chaucer, Shakespeare, and Woolf."),
                Course("English 102", "Advanced Grammar: Delve deep into the complexities of English grammar. This course covers advanced topics such as syntax, morphology, and semantics, and aims to enhance students' understanding and application of grammatical rules in both written and spoken English."),
                Course("English 201", "Shakespearean Studies: An in-depth study of William Shakespeare's works. Students will read and analyze a selection of Shakespeare's plays and sonnets, considering historical context, thematic elements, and the playwright's enduring influence on literature and culture."),
                Course("English 101", "Introduction to English Literature: This course provides a comprehensive overview of English literature from the medieval period to the contemporary era. Students will explore various genres including poetry, drama, and prose, and analyze works from authors such as Chaucer, Shakespeare, and Woolf."),
                Course("English 102", "Advanced Grammar: Delve deep into the complexities of English grammar. This course covers advanced topics such as syntax, morphology, and semantics, and aims to enhance students' understanding and application of grammatical rules in both written and spoken English."),
                Course("English 201", "Shakespearean Studies: An in-depth study of William Shakespeare's works. Students will read and analyze a selection of Shakespeare's plays and sonnets, considering historical context, thematic elements, and the playwright's enduring influence on literature and culture.")
            )
            "Math" -> listOf(
                Course("Math 101", "Calculus I: This course introduces the fundamental concepts of calculus, including limits, derivatives, and integrals. Students will learn to apply these concepts to solve real-world problems and develop a solid foundation for further studies in mathematics."),
                Course("Math 102", "Algebra I: Explore the world of algebra, covering topics such as linear equations, inequalities, polynomials, and quadratic functions. This course aims to build students' problem-solving skills and prepare them for more advanced mathematical studies."),
                Course("Math 201", "Linear Algebra: Focus on vector spaces, linear transformations, and matrices. This course provides essential tools for understanding and solving linear systems, and is particularly useful for students pursuing careers in science, engineering, and mathematics."),
                Course("Math 101", "Calculus I: This course introduces the fundamental concepts of calculus, including limits, derivatives, and integrals. Students will learn to apply these concepts to solve real-world problems and develop a solid foundation for further studies in mathematics."),
                Course("Math 102", "Algebra I: Explore the world of algebra, covering topics such as linear equations, inequalities, polynomials, and quadratic functions. This course aims to build students' problem-solving skills and prepare them for more advanced mathematical studies."),
                Course("Math 201", "Linear Algebra: Focus on vector spaces, linear transformations, and matrices. This course provides essential tools for understanding and solving linear systems, and is particularly useful for students pursuing careers in science, engineering, and mathematics.")
            )
            "Marketing" -> listOf(
                Course("Marketing 101", "Introduction to Marketing: Gain a broad understanding of marketing principles and strategies. This course covers topics such as market research, consumer behavior, product development, pricing strategies, and promotional techniques, providing a solid foundation for a career in marketing."),
                Course("Marketing 102", "Digital Marketing Basics: Explore the world of digital marketing, including social media marketing, search engine optimization (SEO), and online advertising. This course aims to equip students with the skills needed to effectively market products and services in the digital age."),
                Course("Marketing 201", "Marketing Strategy: Develop a strategic approach to marketing, learning how to create comprehensive marketing plans that align with business objectives. This course covers advanced topics such as brand management, competitive analysis, and marketing metrics."),
                Course("Marketing 101", "Introduction to Marketing: Gain a broad understanding of marketing principles and strategies. This course covers topics such as market research, consumer behavior, product development, pricing strategies, and promotional techniques, providing a solid foundation for a career in marketing."),
                Course("Marketing 102", "Digital Marketing Basics: Explore the world of digital marketing, including social media marketing, search engine optimization (SEO), and online advertising. This course aims to equip students with the skills needed to effectively market products and services in the digital age."),
                Course("Marketing 201", "Marketing Strategy: Develop a strategic approach to marketing, learning how to create comprehensive marketing plans that align with business objectives. This course covers advanced topics such as brand management, competitive analysis, and marketing metrics.")
            )
            else -> emptyList()
        }
    }
}
